package ru.skillbox.socialnetwork.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.skillbox.socialnetwork.api.dto.PostParameters;
import ru.skillbox.socialnetwork.api.response.CommentApi;
import ru.skillbox.socialnetwork.api.response.CommentListApi;
import ru.skillbox.socialnetwork.api.response.PostApi;
import ru.skillbox.socialnetwork.api.response.PostDeleteApi;
import ru.skillbox.socialnetwork.api.response.PostListApi;
import ru.skillbox.socialnetwork.api.response.ReportApi;
import ru.skillbox.socialnetwork.api.response.ResponseApi;
import ru.skillbox.socialnetwork.dao.PostDAO;
import ru.skillbox.socialnetwork.model.Post;
import ru.skillbox.socialnetwork.model.PostComment;

@Service
public class PostService {

   @Autowired
   private ReportApi reportApi;
   @Autowired
   private PostApi postApi;
   @Autowired
   private PostListApi postListApi;
   @Autowired
   private PostDeleteApi postDeleteApi;
   @Autowired
   private PostDAO postDAO;

   public ResponseApi get(int id) {
      Post post = postDAO.getPostById(id);
      return post == null ? null : new ResponseApi("none", new Date().getTime(), fillPostApi(post));
   }

   public ResponseApi search(PostParameters postParameters) {
      List<Post> posts = postDAO.getPosts(postParameters);
      postListApi = new PostListApi();
      postListApi.setData(posts.stream().map(this::fillPostApi)
          .collect(Collectors.toList()));
      postListApi.setTotal(posts.size());
      postListApi.setOffset(postParameters.getOffset());
      postListApi.setPerPage(postParameters.getItemPerPage());
      postListApi.setSuccess(true);
      return postListApi;
   }

   public ResponseApi edit(int id,
       ru.skillbox.socialnetwork.api.request.PostApi postApiRequest,
       Long publishDate) {
      Post post = postDAO.getPostById(id);
      if (post == null) {
         return null;
      }
      post.setTitle(postApiRequest.getTitle());
      post.setPostText(postApiRequest.getPostText());
      post.setTime(publishDate != null ? new java.sql.Date(publishDate) : post.getTime());
      postDAO.updatePost(post);
      return new ResponseApi("none", new Date().getTime(), fillPostApi(post));
   }

   public ResponseApi delete(int id) {
      Post post = postDAO.getPostById(id);
      postDAO.deletePost(post);
      postDeleteApi.setId(id);
      return post == null ? null : new ResponseApi("none", new Date().getTime(), postDeleteApi);
   }

   public ResponseApi recover(int id) {
      Post post = postDAO.recoverPost(id);
      return post == null ? null : new ResponseApi("none", new Date().getTime(), fillPostApi(post));
   }

   public ResponseApi reportPost(int id) {
      Post post = postDAO.reportPost(id);
      reportApi.setMessage("Отправлен репорт на пост с id:" + id);
      return post == null ? null : new ResponseApi("none", new Date().getTime(), reportApi);
   }

   public ResponseApi searchComments(int postId, int offset, int itemPerPage) {
      List<PostComment> comments = postDAO.getComments(postId, offset, itemPerPage);
      CommentListApi commentListApi = new CommentListApi();
      commentListApi.setData(comments.stream().map(this::fillCommentApi)
          .collect(Collectors.toList()));
      commentListApi.setTotal(comments.size());
      commentListApi.setOffset(offset);
      commentListApi.setPerPage(itemPerPage);
      commentListApi.setSuccess(true);
      return commentListApi;
   }

   private PostApi fillPostApi(Post post) {
      PostApi postDataApi = new PostApi();
      postDataApi.setId(post.getId());
      postDataApi.setTime(post.getTime().getTime());
      postDataApi.setAuthorId(post.getAuthor().getId());
      postDataApi.setTitle(post.getTitle());
      postDataApi.setPostText(post.getPostText());
      postDataApi.setBlocked(post.isBlocked());
      postDataApi.setLikes(postDAO.getLikesNumber(post.getId()));
      return postDataApi;
   }

   private CommentApi fillCommentApi(PostComment comment) {
      CommentApi commentApi = new CommentApi();
      commentApi.setId(comment.getId());
      commentApi.setTime(comment.getTime().getTime());
      commentApi.setAuthorId(comment.getAuthor().getId());
      commentApi.setCommentText(comment.getCommentText());
      //TODO какой ответ должен быть при отсутсвии родителя
      commentApi.setParentId(comment.getParent() == null ? -1 : comment.getParent().getId());
      commentApi.setPostId(String.valueOf(comment.getPost().getId()));
      commentApi.setBlocked(comment.isBlocked());
      return commentApi;
   }
}
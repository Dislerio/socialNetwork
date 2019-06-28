package ru.skillbox.socialnetwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.skillbox.socialnetwork.api.request.PostCommentApi;
import ru.skillbox.socialnetwork.api.response.PostApi;
import ru.skillbox.socialnetwork.service.PostService;

@Controller
@RequestMapping("/api/v1/post")
public class PostController {

   @Autowired
   PostService postService;

   /**
    * Поиск публикации
    *
    * @param text Текст публикации
    * @param dateFrom Дата публикации ОТ
    * @param dateTo Дата публикации ДО
    * @param offset Отступ от начала списка
    * @param itemPerPage Количество элементов на страницу
    */
   @GetMapping("/")
   public ResponseEntity getPost(@RequestParam String text,
       @RequestParam(value = "date_from", required = false) Number dateFrom,
       @RequestParam(value = "date_to", required = false) Number dateTo,
       @RequestParam(required = false) int offset,
       @RequestParam(required = false, defaultValue = "20") int itemPerPage) {
      //TODO: Требуется реализация
      return null;
   }

   /**
    * Получение публикации по ID
    */
   @GetMapping("/{id:\\d+}")
   public ResponseEntity getPostById(@PathVariable int id) {
      if (postService.get(id) != null) {
         return new ResponseEntity<>(postService.get(id), HttpStatus.OK);
      } else {
         return responseError400();
      }


   }

   /**
    * Редактирование публикации по ID
    *
    * @param publishDate Отложить до даты определенной даты
    */
   @PutMapping("/{id:\\d+}")
   public ResponseEntity editPostById(@RequestBody PostApi request,
       @PathVariable int id,
       @RequestParam(value = "publish_date", required = false) Number publishDate) {
      //TODO: Требуется реализация
      return null;
   }

   /**
    * Удаление публикации по ID
    */
   @DeleteMapping("/{id:\\d+}")
   public ResponseEntity deletePostById(@PathVariable int id) {
      //TODO: Требуется реализация
      return null;
   }

   /**
    * Восстановление публикации по ID
    */
   @PutMapping("/{id:\\d+}/recover")
   public ResponseEntity recoverPostById(@PathVariable int id) {
      //TODO: Требуется реализация
      return null;
   }

   /**
    * Получение комментариев на публикации
    *
    * @param offset Отступ от начала списка
    * @param itemPerPage Количество элементов на страницу
    */
   @GetMapping("/{id:\\d+}/comments")
   public ResponseEntity getPostingComments(@PathVariable int id,
       @RequestParam(required = false) int offset,
       @RequestParam(required = false, defaultValue = "20") int itemPerPage) {
      //TODO: Требуется реализация
      return null;
   }

   /**
    * Создание комментария к публикации
    *
    * @param id ID публикации
    */
   @PostMapping("/{id:\\d+}/comments")
   public ResponseEntity createPostingComment(@RequestBody PostCommentApi request,
       @PathVariable int id) {
      //TODO: Требуется реализация
      return null;
   }

   /**
    * Редактирование комментария к публикации
    *
    * @param id ID публикации
    * @param commentId ID комментария публикации
    */
   @PutMapping("/{id:\\d+}/comments/{comment_id:\\d+}")
   public ResponseEntity editPostingComment(@RequestBody PostCommentApi request,
       @PathVariable int id,
       @RequestParam(value = "comment_id ") int commentId) {
      //TODO: Требуется реализация
      return null;
   }

   /**
    * Удаление комментария к публикации
    *
    * @param id ID публикации
    * @param commentId ID комментария публикации
    */
   @DeleteMapping("/{id:\\d+}/comments/{comment_id:\\d+}")
   public ResponseEntity deletePostingComment(@PathVariable int id,
       @PathVariable(value = "comment_id ") int commentId) {
      //TODO: Требуется реализация
      return null;
   }

   /**
    * Восстановление комментария
    *
    * @param id ID публикации
    * @param commentId ID комментария публикации
    */
   @PutMapping("/{id:\\d+}/comments/{comment_id:\\d+}/recover")
   public ResponseEntity recoverPostingComment(@PathVariable int id,
       @PathVariable(value = "comment_id ") int commentId) {
      //TODO: Требуется реализация
      return null;
   }

   /**
    * Подать жалобу на публикацию
    *
    * @param id ID публикации
    */
   @PostMapping("/{id:\\d+}/report")
   public ResponseEntity sendReportToPost(@PathVariable int id) {
      //TODO: Требуется реализация
      return null;
   }

   /**
    * Подать жалобу на комментарий к публикации
    *
    * @param id ID публикации
    * @param commentId ID комментария публикации
    */
   @PostMapping("/{id:\\d+}/comments/{comment_id:\\d+}/report")
   public ResponseEntity sendReportToPostingComment(@PathVariable int id,
       @PathVariable(value = "comment_id ") int commentId) {
      //TODO: Требуется реализация
      return null;
   }

   private ResponseEntity<Object> responseError400() {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
   }
}

package ru.skillbox.socialnetwork.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {

   private static final String EMAIL = "sidorovmaxim@mail.ru";//email пользователя для
   private final String PATH_POST = "/post";

   @Autowired
   private PostController controller;
   @Autowired
   private MockMvc mvc;

   @WithUserDetails(EMAIL)
   @Test
   public void get_by_id_success_response() throws Exception {
      mvc.perform(get(PATH_POST + "/{id}", "1")
          .contentType(MediaType.APPLICATION_JSON_UTF8)
          .with(csrf()))
          .andExpect(status().isOk())
          .andExpect(content().string(containsString("error")))
          .andExpect(content().string(containsString("timestamp")))
          .andExpect(content().string(containsString("data")))
          .andDo(MockMvcResultHandlers.print());
   }

   @WithUserDetails(EMAIL)
   @Test
   public void get_by_id_bad_request() throws Exception {
      mvc.perform(get(PATH_POST + "/{id}", "99999999")
          .contentType(MediaType.APPLICATION_JSON_UTF8)
          .with(csrf()))
          .andExpect(status().isBadRequest())
          .andExpect(content().string(containsString("error_description")))
          .andExpect(content().string(containsString("error")))
          .andDo(MockMvcResultHandlers.print());
   }

   @Test
   public void get_by_id_wo_authorization() throws Exception {
      mvc.perform(get(PATH_POST + "/{id}", "1")
          .contentType(MediaType.APPLICATION_JSON_UTF8)
          .with(csrf()))
          .andExpect(status().isUnauthorized())
          .andDo(MockMvcResultHandlers.print());
   }

   @WithUserDetails(EMAIL)
   @Test
   public void search_post_success_response() throws Exception {
      mvc.perform(get(PATH_POST + "/")
          .param("text", "Масленица")
          .contentType(MediaType.APPLICATION_JSON_UTF8)
          .with(csrf()))
          .andExpect(status().isOk())
          .andExpect(content().string(containsString("error")))
          .andExpect(content().string(containsString("timestamp")))
          .andExpect(content().string(containsString("total")))
          .andExpect(content().string(containsString("offset")))
          .andExpect(content().string(containsString("perPage")))
          .andExpect(content().string(containsString("data")))
          .andDo(MockMvcResultHandlers.print());
   }

   @WithUserDetails(EMAIL)
   @Test
   public void edit_by_id_success_response() throws Exception {
      mvc.perform(put(PATH_POST + "/{id}", "1")
          .param("publish_date", "1559751301818")
          .contentType(MediaType.APPLICATION_JSON_UTF8)
          .with(csrf())
          .content("{\n"
              + "  \"title\": \"string\",\n"
              + "  \"post_text\": \"string\",\n"
              + "  \"tags\": [\n"
              + "    \"tag1\"\n"
              + "  ]\n"
              + "}"))
          .andExpect(status().isOk())
          .andExpect(content().string(containsString("error")))
          .andExpect(content().string(containsString("timestamp")))
          .andExpect(content().string(containsString("data")))
          .andDo(MockMvcResultHandlers.print());
   }

   @WithUserDetails(EMAIL)
   @Test
   public void recover_by_id_success_response() throws Exception {
      mvc.perform(put(PATH_POST + "/{id}/recover", "1")
          .contentType(MediaType.APPLICATION_JSON_UTF8)
          .with(csrf()))
          .andExpect(status().isOk())
          .andExpect(content().string(containsString("error")))
          .andExpect(content().string(containsString("timestamp")))
          .andExpect(content().string(containsString("data")))
          .andDo(MockMvcResultHandlers.print());
   }

   @WithUserDetails(EMAIL)
   @Test
   public void report_by_id_success_response() throws Exception {
      mvc.perform(post(PATH_POST + "/{id}/report", "1")
          .contentType(MediaType.APPLICATION_JSON_UTF8)
          .with(csrf()))
          .andExpect(status().isOk())
          .andExpect(content().string(containsString("error")))
          .andExpect(content().string(containsString("timestamp")))
          .andExpect(content().string(containsString("data")))
          .andExpect(content().string(containsString("message")))
          .andDo(MockMvcResultHandlers.print());
   }

   @WithUserDetails(EMAIL)
   @Test
   public void delete_by_id_success_response() throws Exception {
      mvc.perform(delete(PATH_POST + "/{id}", "1")
          .contentType(MediaType.APPLICATION_JSON_UTF8)
          .with(csrf()))
          .andExpect(status().isOk())
          .andExpect(content().string(containsString("error")))
          .andExpect(content().string(containsString("timestamp")))
          .andExpect(content().string(containsString("data")))
          .andDo(MockMvcResultHandlers.print());
   }

   @WithUserDetails(EMAIL)
   @Test
   public void get_comments_success_response() throws Exception {
      mvc.perform(get(PATH_POST + "/{id}/comments", "1")
          .contentType(MediaType.APPLICATION_JSON_UTF8)
          .param("offset", "0")
          .with(csrf()))
          .andExpect(status().isOk())
          .andExpect(content().string(containsString("error")))
          .andExpect(content().string(containsString("timestamp")))
          .andExpect(content().string(containsString("total")))
          .andExpect(content().string(containsString("offset")))
          .andExpect(content().string(containsString("perPage")))
          .andExpect(content().string(containsString("data")))
          .andDo(MockMvcResultHandlers.print());
   }

   @WithUserDetails(EMAIL)
   @Test
   public void post_comment_success_response() throws Exception {
      mvc.perform(post(PATH_POST + "/{id}/comments", "1")
          .contentType(MediaType.APPLICATION_JSON_UTF8)
          .param("offset", "0")
          .with(csrf())
          .content("{\n"
              + "  \"parent_id\": 1,\n"
              + "  \"comment_text\": \"string\",\n"
              + "  \"id\": 111,\n"
              + "  \"time\": 1559751301818,\n"
              + "  \"author\": {\n"
              + "    \"id\": 1,\n"
              + "    \"first_name\": \"Петр\",\n"
              + "    \"last_name\": \"Петрович\",\n"
              + "    \"photo\": \"https://...../photos/image123.jpg\",\n"
              + "    \"last_online_time\": 1559751301818\n"
              + "  },\n"
              + "  \"is_blocked\": true\n"
              + "}"))
          .andExpect(status().isOk())
          .andExpect(content().string(containsString("error")))
          .andExpect(content().string(containsString("timestamp")))
          .andExpect(content().string(containsString("data")))
          .andDo(MockMvcResultHandlers.print());
   }

   @WithUserDetails(EMAIL)
   @Test
   public void edit_comment_by_id_success_response() throws Exception {
      mvc.perform(put(PATH_POST + "/{id}/comments/{comments_id}", "1", "1")
          .contentType(MediaType.APPLICATION_JSON_UTF8)
          .with(csrf())
          .content("{\n"
              + "  \"parent_id\": 1,\n"
              + "  \"comment_text\": \"string\",\n"
              + "  \"id\": 111,\n"
              + "  \"time\": 1559751301818,\n"
              + "  \"author\": {\n"
              + "    \"id\": 1,\n"
              + "    \"first_name\": \"Петр\",\n"
              + "    \"last_name\": \"Петрович\",\n"
              + "    \"photo\": \"https://...../photos/image123.jpg\",\n"
              + "    \"last_online_time\": 1559751301818\n"
              + "  },\n"
              + "  \"is_blocked\": true\n"
              + "}"))
          .andExpect(status().isOk())
          .andExpect(content().string(containsString("error")))
          .andExpect(content().string(containsString("timestamp")))
          .andExpect(content().string(containsString("data")))
          .andDo(MockMvcResultHandlers.print());
   }

   @WithUserDetails(EMAIL)
   @Test
   public void delete_comment_by_id_success_response() throws Exception {
      mvc.perform(delete(PATH_POST + "/{id}/comments/{comments_id}", "1", "1")
          .contentType(MediaType.APPLICATION_JSON_UTF8)
          .with(csrf()))
          .andExpect(status().isOk())
          .andExpect(content().string(containsString("error")))
          .andExpect(content().string(containsString("timestamp")))
          .andExpect(content().string(containsString("data")))
          .andDo(MockMvcResultHandlers.print());
   }

   @WithUserDetails(EMAIL)
   @Test
   public void recover_comment_by_id_success_response() throws Exception {
      mvc.perform(put(PATH_POST + "/{id}/comments/{comments_id}/recover", "1", "1")
          .contentType(MediaType.APPLICATION_JSON_UTF8)
          .with(csrf()))
          .andExpect(status().isOk())
          .andExpect(content().string(containsString("error")))
          .andExpect(content().string(containsString("timestamp")))
          .andExpect(content().string(containsString("data")))
          .andDo(MockMvcResultHandlers.print());
   }

   @WithUserDetails(EMAIL)
   @Test
   public void report_comment_by_id_success_response() throws Exception {
      mvc.perform(post(PATH_POST + "/{id}/comments/{comments_id}/report", "1", "1")
          .contentType(MediaType.APPLICATION_JSON_UTF8)
          .with(csrf()))
          .andExpect(status().isOk())
          .andExpect(content().string(containsString("error")))
          .andExpect(content().string(containsString("timestamp")))
          .andExpect(content().string(containsString("data")))
          .andExpect(content().string(containsString("message")))
          .andDo(MockMvcResultHandlers.print());
   }
}

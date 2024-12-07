package vn.iotstar.UTEExpress.controllers.admin;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import vn.iotstar.UTEExpress.entity.Post;
import vn.iotstar.UTEExpress.model.PostModel;
import vn.iotstar.UTEExpress.service.interfaces.IPostService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
@RequestMapping("/admin/post")
public class PostController {
	@Autowired
	IPostService postService ;
	
	@GetMapping("")
	public String findAllPost(Model model) {
		List <Post> post = postService.findAllPost();
		model.addAttribute("post",post);
		
		return "admin/listPost";
	}
	
	@GetMapping("/addPost")
	public String addPost(Model model) {
		PostModel post = new PostModel();
		model.addAttribute("post",post);
		return "admin/addPost";
	}
	
	@GetMapping("/edit")
	public String editPost(@RequestParam("id") String IDPost, Model model, 
			RedirectAttributes redirectAttributes) {
		// Lấy bài viết từ database theo ID
	    Post post = postService.findById(IDPost).orElse(null);

	    // Nếu không tìm thấy, thêm thông báo lỗi
	    if (post == null) {
	    	redirectAttributes.addFlashAttribute("message", "Error: Post not found!");
	        return "redirect:/admin/post";
	    }
	    
	    PostModel postModel = new PostModel();
	    postModel.setIDPost(post.getIDPost());
	    postModel.setNamePost(post.getNamePost());
	    model.addAttribute("post", postModel);
	    
		return "admin/editPost";
	}
	
	@GetMapping("/delete")
	public String deletePost(@RequestParam("id") String IDPost, RedirectAttributes redirectAttributes ) {
		postService.deletePost(IDPost);
		redirectAttributes.addFlashAttribute("message", "Post deleted successfully!");
		
		return "redirect:/admin/post";
	}
	
	@PostMapping("/update")
	public String FormEditPost(@ModelAttribute("post") PostModel postModel, RedirectAttributes redirectAttributes) {
		// Lấy bài viết từ database theo ID
        Post existingPost = postService.findById(postModel.getIDPost()).orElse(null);

        if (existingPost == null) {
            redirectAttributes.addFlashAttribute("message", "Error: Unable to update. Post not found!");
            return "redirect:/admin/post";
        }

        // Cập nhật thông tin bài viết
        existingPost.setIDPost(postModel.getIDPost());
        existingPost.setNamePost(postModel.getNamePost());
        postService.savePost(existingPost);

        // Thêm thông báo thành công
        redirectAttributes.addFlashAttribute("message", "Post updated successfully!");
        return "redirect:/admin/post";
	}
	
	@PostMapping("/addPost")
	public String FormAddPost(@ModelAttribute("post") Post post, Model model, RedirectAttributes redirectAttributes) {
		// Lưu bài viết
	    postService.savePost(post);

	    // Thêm thông báo thành công
	    redirectAttributes.addFlashAttribute("message", "Post added successfully!");

	    // Chuyển hướng đến trang danh sách bài viết
	    return "redirect:/admin/post";
	}
	
	
	
	
	
}

package main;

import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
@RestController
public class LoginController {

    // 假设账号密码写死，实际可查数据库
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "123456";

    @PostMapping("/api/login")
    public Map<String, Object> login(@RequestParam String username,
                                     @RequestParam String password,
                                     HttpSession session) {
        Map<String, Object> result = new HashMap<>();
        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            session.setAttribute("user", username);
            result.put("success", true);
        } else {
            result.put("success", false);
            result.put("msg", "用户名或密码错误");
        }
        return result;
    }

    @PostMapping("/api/logout")
    public void logout(HttpSession session) {
        session.invalidate();
    }
}
package com.example.web1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;
    private String roles;
    private boolean enabled;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "user_post_id")
    private List<Post> posts = new ArrayList<>();

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "user_comment_id")
    private List<Comment> comments = new ArrayList<>();
    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setCommenter(this);
    }



//    INSERT INTO `users` (`username`, `email`,`password`, `enabled`) VALUES ('tung', 'tung@gmail.com','$2y$12$CcIz.p.8E7n7JU46SFwLke.JL5AJXc3KNLinH82w2FqKeDZtrk3/C', '1');
//    INSERT INTO `users` (`username`, `email`,`password`, `enabled`) VALUES ('cuong', 'cuong@gmail.com', '$2y$12$CcIz.p.8E7n7JU46SFwLke.JL5AJXc3KNLinH82w2FqKeDZtrk3/C', '1');
//    INSERT INTO `users` (`username`, `email`,`password`, `enabled`) VALUES ('tuan', 'tuan@gmail.com', '$2y$12$CcIz.p.8E7n7JU46SFwLke.JL5AJXc3KNLinH82w2FqKeDZtrk3/C', '1');
//    INSERT INTO `users` (`username`, `email`,`password`, `enabled`) VALUES ('dung', 'dungusers@gmail.com', '$2y$12$CcIz.p.8E7n7JU46SFwLke.JL5AJXc3KNLinH82w2FqKeDZtrk3/C', '1');


}
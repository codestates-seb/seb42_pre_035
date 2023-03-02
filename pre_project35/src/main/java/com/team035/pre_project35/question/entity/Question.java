package com.team035.pre_project35.question.entity;

import com.team035.pre_project35.answer.entity.Answer;
import com.team035.pre_project35.audit.Auditable;
import com.team035.pre_project35.user.entity.User;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Question extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int questionId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String questionBody;

    @Column(nullable = false)
    private int voteCount;

    @Column(nullable = false)
    private int viewCount;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers = new ArrayList<>();

    public Question(String title, String questionBody) {
        this.title = title;
        this.questionBody = questionBody;
    }
}

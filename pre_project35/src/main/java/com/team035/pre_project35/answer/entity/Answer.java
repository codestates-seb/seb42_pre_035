package com.team035.pre_project35.answer.entity;

import com.team035.pre_project35.audit.Auditable;
import com.team035.pre_project35.question.entity.Question;
import com.team035.pre_project35.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@Getter
@Setter
public class Answer extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int answerId;

    @Column(nullable = false)
    private String answerBody;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    public void addQuestion(Question question){
        this.question = question;
    }

}

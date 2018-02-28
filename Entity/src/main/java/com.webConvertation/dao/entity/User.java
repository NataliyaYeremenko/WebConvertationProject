package com.webConvertation.dao.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nataliya on 08.02.2017.
 */
@Entity
@Table (name = "user")
public class User {

    private long idUser;
    private String name;
    private String email;
    private String password;

    private Set<InputFile> inputFiles = new HashSet<InputFile>();

    private  Set<OutputFile> outputFiles = new HashSet<OutputFile>();

    private Set<Comments> commentsSet = new HashSet<Comments>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    //@JoinColumn(name = "idImage")
    public Set<InputFile> getInputFiles() {
        return inputFiles;
    }

    public void setInputFiles(Set<InputFile> inputFiles) {
        this.inputFiles = inputFiles;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    //@JoinColumn(name = "idImage")
    public Set<OutputFile> getOutputFiles() {
        return outputFiles;
    }

    public void setOutputFiles(Set<OutputFile> outputFiles) {
        this.outputFiles = outputFiles;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    //@JoinColumn(name = "idComment")
    public Set<Comments> getCommentsSet() { return commentsSet; }

    public void setCommentsSet(Set<Comments> commentsSet) {
        this.commentsSet = commentsSet;
    }


    public User() {
        name = null;
    }

    public User(String name, String email, String password){
        this.name=name;
        this.email=email;
        this.password=password;
    }

    public User(String name, String email, String password, Set<InputFile> inputFiles, Set<OutputFile> outputFiles, Set<Comments> comments) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.inputFiles = inputFiles;
        this.outputFiles = outputFiles;
        this.commentsSet = comments;
    }

    @Id
    @GeneratedValue (generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column (name = "idUser")
    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    @Column (name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column (name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column (name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", inputfiles=" + inputFiles +
                ", outputfiles=" + outputFiles +
                ", comments=" + commentsSet +
                '}';
    }
}

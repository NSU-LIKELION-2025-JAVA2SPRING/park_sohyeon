package nsu.domain;

/*
전체 흐름 Main -> Controller -> Service -> Repository -> Domain
게시글 구조 및 데이터 규칙 관리
생성, 제목 유효성 검사, 제목 수정*/

public class Post {

    // 게시글마다 고유한 ID를 줌
    private static long idCounter = 0;

    // ID가 변경되지 않도록 final
    private final long id;
    private String title;


    // 게시글 만들때 id 자동으로 증가시킴
    public Post(String title){
        validationTitle(title);
        this.id = ++idCounter;
        this.title = title;
    }

    public long getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    // 제목 수정, 새로운 제목=newTitle도 유효성 만족해야됨
    public void updateTitle(String newTitle){
        validationTitle(newTitle);
        this.title = newTitle;
    }

    // 유효성 (제목이 비어있을 수 없음 & 30자 이내로 구성)
    private void validationTitle(String title){
        if(title == null || title.isBlank()){
            throw new IllegalArgumentException("제목이 비었습니다.");
        } if (title.length() > 30){
            throw new IllegalArgumentException("제목은 30자 이내로 작성해주세요.");
        }
    }








}

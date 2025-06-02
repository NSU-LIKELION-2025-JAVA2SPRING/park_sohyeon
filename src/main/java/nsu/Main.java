package nsu;

import nsu.controller.PostController;
import nsu.domain.Post;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PostController controller = new PostController();
        boolean running = true;

        while (running) {
            System.out.println("\n=== 게시판 메뉴 ===");
            System.out.println("1. 게시글 작성");
            System.out.println("2. 전체 게시글 조회");
            System.out.println("3. 게시글 상세 조회");
            System.out.println("4. 게시글 수정");
            System.out.println("5. 게시글 삭제");
            // 키워드 검색 기능 추가
            System.out.println("6. 게시글 검색");
            System.out.println("0. 종료");
            System.out.print("선택: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.print("제목: ");
                    String title = scanner.nextLine();
                    controller.createPost(title);
                    System.out.println("게시글이 작성되었습니다.");
                }
                case 2 -> {
                    List<Post> posts = controller.getAllPosts();
                    if (posts.isEmpty()) {
                        System.out.println("등록된 게시글이 없습니다.");
                    } else {
                        for (Post post : controller.getAllPosts()) {
                            System.out.printf("🆔 %d | 📌 제목: %s\n", post.getId(), post.getTitle());
                        }
                    }
                }
                case 3 -> {
                    System.out.print("조회할 게시글 ID: ");
                    Long id = Long.parseLong(scanner.nextLine());
                    Post post = controller.getPostById(id);
                    if (post != null) {
                        System.out.printf("🆔 ID: %d\n", post.getId());
                        System.out.printf("📌 제목: %s\n", post.getTitle());
                    } else {
                        System.out.println("해당 ID의 게시글이 없습니다.");
                    }
                }
                case 4 -> {
                    System.out.print("수정할 게시글 ID: ");
                    Long id = Long.parseLong(scanner.nextLine());
                    System.out.print("새 제목: ");
                    String title = scanner.nextLine();
                    controller.updatePost(id, title);
                    System.out.println("게시글이 수정되었습니다.");
                }
                case 5 -> {
                    System.out.print("삭제할 게시글 ID: ");
                    Long id = Long.parseLong(scanner.nextLine());
                    controller.deletePost(id);
                    System.out.println("게시글이 삭제되었습니다.");
                }
                case 6 -> {
                    System.out.println("검색어를 입력해주세요 : ");
                    String keyword = scanner.nextLine();
                    List<Post> posts = controller.searchPost(keyword);
                    if (posts.isEmpty()){
                        System.out.println("검색 결과가 없습니다.");
                    } else {
                        for(Post post : controller.searchPost(keyword)){
                            System.out.printf("🆔 %d | 📌 제목: %s\n", post.getId(), post.getTitle());
                        }
                    }
                    System.out.println("검색이 완료되었습니다.");
                }
                case 0 -> {
                    running = false;
                    System.out.println("프로그램을 종료합니다.");
                }
                default -> System.out.println("잘못된 선택입니다. 다시 시도해주세요.");
            }
        }

        scanner.close();
    }
}


//package com.codeup.adlister.dao;
//
//import com.codeup.adlister.models.Task;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ListTasksDao implements Tasks {
//    private List<Task> tasks;
//
//    public List<Task> all() {
//        if (tasks == null) {
//            tasks = generateAds();
//        }
//        return tasks;
//    }
//
//    public Long insert(Task task) {
//        // make sure we have ads
//        if (tasks == null) {
//            tasks = generateAds();
//        }
//        // we'll assign an "id" here based on the size of the ads list
//        // really the dao would handle this
//        task.setId((long) tasks.size());
//        tasks.add(task);
//        return task.getId();
//    }
//
//    private List<Task> generateAds() {
//        List<Task> tasks = new ArrayList<>();
//        tasks.add(new Task(
//            1,
//            1,
//            "playstation for sale",
//            "This is a slightly used playstation"
//        ));
//        tasks.add(new Task(
//            2,
//            1,
//            "Super Nintendo",
//            "Get your game on with this old-school classic!"
//        ));
//        tasks.add(new Task(
//            3,
//            2,
//            "Junior Java Developer Position",
//            "Minimum 7 years of experience required. You will be working in the scripting language for Java, JavaScript"
//        ));
//        tasks.add(new Task(
//            4,
//            2,
//            "JavaScript Developer needed",
//            "Must have strong Java skills"
//        ));
//        return tasks;
//    }
//}

//package com.command;
//
//import java.util.List;
//
//public class Command {
//    private String[] command;
//
//    private List<String> file;
//
//    private List<Enum> options;
//
//    public Command(String command) {
//        this.command = command.split(" ");
//    }
//
//    private void interpreteCommand(){
//        for (String element : command) {
//            if(isFile(element))
//                file.add(element);
////            else
////                options.add(element.replace("-",""));
//        }
//    }
//
//    private boolean isFile(String element) {
//        return !element.startsWith("-");
//    }
//
//}

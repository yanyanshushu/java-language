package com.sunqian.work;

import com.sunqian.file.FileTest;

import java.util.List;

public class PartRoomIdTest {
    public static void main(String[] args) {

        List<String> room = FileTest.readSetFromFile("D:\\temp.txt");

        String[] sqls=new String[32];
        for(int i=0;i<32;i++){
//            sqls[i]="myIM_message"+i+".db: " +
//                    "DELETE from message WHERE  room_id in (";
            sqls[i]="myIM_session"+i+".db:\n" +
                    "DELETE from session_connect_info WHERE  room_id in (";
        }
        for(String roomId:room){
            int roomIdInt=Integer.parseInt(roomId);
            int mo=roomIdInt%32;
            sqls[mo]=sqls[mo]+roomId+",";
        }
        for(int i=0;i<32;i++){
            System.out.println(sqls[i]);
        }
    }
}

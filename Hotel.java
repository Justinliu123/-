package Hotel_management_system;
/**
 * @author wolf
 * @date 02/11/2021
 *
 * 作用：管理酒店房间，负责对酒店房间的操作
 * */
class Hotel {
    private int STOREY = 5;                 //酒店层数
    private int ROOM = 10;                  //每层房间数
    private Room[][] rooms;                //所有的酒店房间
    //初始化酒店的所有房间，每双层的双号为双人间。
    Hotel() {
        rooms = new Room[STOREY + 1][ROOM + 1];
        int num;
        String type;
        for (int i = 1; i <= STOREY; i++) {
            for (int j = 1; j <= ROOM; j++) {
                type = "单人间";
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        type = "双人间";
                    }
                }
                rooms[i][j] = new Room(i * 100 + j, type, 0);
            }
        }
    }

    //查找房间号对应的下标数组（第一位行，第二位列），找不到返回0,0。
    int[] searchRoom(int number){
        int arr[] = {0,0};
        for (int i = 1; i < rooms.length; i++) {
            for (int j = 1; j < rooms[i].length; j++) {
                if(number == rooms[i][j].getNumber()){
                    arr[0] = i; arr[1] = j;
                }
            }
        }
        return arr;
    }
    /**
     * 查找是否存在对应房间号的房间
     * @param roomNumber 要找的房间号
     */
    boolean isExistRoom(int roomNumber){
        int[] arr = searchRoom(roomNumber);
        if(arr[0] == 0 && arr[1] == 0)
            return false;
        return true;
    }

    /**
     * 查找对应房间号的状态信息（int型）
     * @param roomNumber 要找的房间号
     * @return 返回整型的房间状态信息
     */
    int getConditionNum(int roomNumber){
        int[] arr = searchRoom(roomNumber);
        if(arr[0] == 0 && arr[1] == 0)
            return -1;
        return rooms[arr[0]][arr[1]].getConditionNum();
    }

    /**
     * 查找对应房间号的状态信息（String型）
     * @param roomNumber 要找的房间号
     * @return 返回文字写明的房间状态信息
     */
    String getConditionStr(int roomNumber){
        int[] arr = searchRoom(roomNumber);
        if(arr[0] == 0 && arr[1] == 0)
            return null;
        return rooms[arr[0]][arr[1]].getConditionStr();
    }

    /**
     * 获取对应房间号的房间对象
     * @param roomNumber 要找的房间号
     * @return 返回对应的房间对象
     */
    Room getRoomObj(int roomNumber){
        int[] arr = searchRoom(roomNumber);
        if (arr[0] == 0 && arr[1] == 0)
            return null;
        return rooms[arr[0]][arr[1]];
    }

    Room[][] getRooms(){
        return rooms;
    }

    /**
     * 设置对应房间号的房间状态信息
     * @param roomNumber 要找的房间号
     * @param condition 要设置的房间状态
     * @return 设置成功返回true, 失败返回false
     */
    boolean setCondition(int roomNumber,int condition){
        int[] arr = searchRoom(roomNumber);
        if(arr[0] == 0 && arr[1] == 0)
            return false;
        rooms[arr[0]][arr[1]].setCondition(condition);
        return true;
    }

}

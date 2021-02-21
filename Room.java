package Hotel_management_system;

import java.util.Objects;

/**
 * 作者：wolf
 * 日期：02/11/2021
 *
 * 类名：Room
 * 作用：酒店管理系统中的房间类
 * */
class Room {
    private int number;     //房间号： 5层 每层10个房间
    private String type;    //房间类型
    private int condition;     //房间是否空闲 有被预约状态 1， 有空置状态 0， 有占用状态 2；

    public Room() {
        number = 0;
        type = null;
        condition = 0;
    }

    public Room(int number, String type, int condition) {
        this.number = number;
        this.type = type;
        this.condition = condition;
    }
    public void setAll(int number, String type, int condition){
        this.number = number;
        this.type = type;
        this.condition = condition;
    }

    public int getNumber() {
        return number;
    }

    public int getCondition() {
        return condition;
    }

    public String getType() {
        return type;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    //重写equals方法
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return number == room.number && condition == room.condition && Objects.equals(type, room.type);
    }
    
    //重写toString方法
    public String toString() {
        return "Room{" +
                "number=" + number +
                ", type='" + type + '\'' +
                ", condition=" + condition +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, type, condition);
    }
}

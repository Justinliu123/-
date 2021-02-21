package Hotel_management_system;

import java.util.Objects;

/**
 * @author wolf
 * @date 02/11/2021
 *
 * 作用： 系统管理员类，登录系统使用的管理员账户
 * */
class Admin{
    String ID;                          //账户ID
    final private int userName;         //登录账户
    private String password;            //登录密码

    //Admin的构造函数。只有ID、账户、密码全部确定才可创建一个管理员账户。
    Admin(String ID,int userName,String password){
        this.ID = ID;
        this.userName = userName;
        this.password = password;
    }

    public int getUserName() {
        return userName;
    }

    /**
     * @param oldPassword 旧密码
     * @param newpassword 新密码
     * @return 修改密码成功返回true，失败返回false
     * */
    public boolean setPassword(String oldPassword,String newpassword) {
        if (oldPassword.equals(password)){
            password = newpassword;
            return true;
        }
        return false;
    }

    public String getPassword() {
        return password;
    }

    @Override
    //重写equals方法，用户名唯一，只要用户名相同就是同一个账户
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return userName == admin.userName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "ID='" + ID + '\'' +
                ", userName=" + userName +
                ", password='" + password + '\'' +
                '}';
    }
}

package Hotel_management_system;

/**
 * @author wolf
 * @date 02/11/2021
 *
 * 作用：酒店管理系统的登录类。
 * */
class Login{
    private Admin[] allUser = new Admin[10];    //设置用户限额最多10个账户
    int adminSize = 0;                          //当前账户数量
    /**
     * @param number 输入的登录账户
     * @param password 输入的登录密码
     * @return 登录成功返回登录的管理员ID,登录失败返回null
     * 备注：账户的账户号唯一
     * */
    String signIn(int number,String password){
        if(adminSize == 0){
            return null;
        }
        for (int i = 0; i < adminSize; i++){
            if(allUser[i].getUserName() == number){
                if(allUser[i].getPassword().equals(password))
                    return allUser[i].ID;
                else
                    return null;
            }
        }
        return null;
    }
    //检测账户号是否重复
    boolean isRepetition(int number){
        if(adminSize == 0){
            return false;
        }
        for (int i = 0; i < adminSize; i++){
            if(allUser[i].getUserName() == number)
                return true;
        }
        return false;
    }

    boolean signUp(String ID, int number, String password){
        allUser[adminSize] = new Admin(ID,number,password);
        adminSize++;
        return true;
    }
    //注销账户，将账户注销后，数组补齐
    boolean logout(int number,String password){
        boolean isfind = false;
        for (int i = 0; i < adminSize; i++){
            if(isfind){
                allUser[i-1] = allUser[i];
            }
            if(allUser[i].getUserName() == number) {
                if(allUser[i].getPassword().equals(password)){
                    isfind = true;
                }
                else
                    break;
            }
        }
        if(isfind) {
            adminSize--;
            return true;
        }
        return false;
    }
    boolean modifiPassword(int number,String oldPassword,String newPassword){
        if(adminSize == 0){
            return false;
        }
        for (int i = 0; i < adminSize; i++){
            if(allUser[i].getUserName() == number){
                if(allUser[i].setPassword(oldPassword,newPassword))
                    return true;
                else
                    return false;
            }
        }
        return false;
    }
}

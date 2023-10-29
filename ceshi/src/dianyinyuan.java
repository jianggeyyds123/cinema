import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class dianyinyuan {
    private static Map<String, String> userPasswords = new HashMap<>();
    private static Map<String, String> employeePasswords = new HashMap<>();  // 添加员工密码

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("欢迎使用影院管理系统!");

        while (true) {
            System.out.println("请选择登录身份:");
            System.out.println("1. 管理员");
            System.out.println("2. 经理");
            System.out.println("3. 前台");
            System.out.println("4. 用户");
            System.out.println("5. 退出系统");
            System.out.print("请选择登录身份: ");
            int loginChoice = scanner.nextInt();
            scanner.nextLine();  // 消耗掉输入缓冲区中的换行符

            switch (loginChoice) {
                case 1:
                    // 管理员登录
                    System.out.print("请输入管理员用户名: ");
                    String adminUsername = scanner.nextLine();
                    System.out.print("请输入管理员密码: ");
                    String adminPassword = scanner.nextLine();
                    if ("admin".equals(adminUsername) && "ynuinfo#777".equals(adminPassword)) {
                        System.out.println("管理员登录成功！");
                        // 添加管理员的 switch 语句
                        while (true) {
                            System.out.println("管理员功能菜单:");
                            System.out.println("1. 密码管理");
                            System.out.println("2. 用户管理");
                            System.out.println("3. 退出登录");
                            System.out.print("请选择操作: ");
                            int adminChoice = scanner.nextInt();
                            scanner.nextLine();  // 消耗掉输入缓冲区中的换行符

                            switch (adminChoice) {
                                // ... （管理员功能代码）
                                case 1:
                                    // 密码管理
                                    System.out.println("密码管理功能:");
                                    System.out.println("1. 修改自身密码");
                                    System.out.println("2. 重置用户密码");
                                    System.out.print("请选择操作: ");
                                    int passwordChoice = scanner.nextInt();
                                    scanner.nextLine();  // 消耗掉输入缓冲区中的换行符

                                    switch (passwordChoice) {
                                        case 1:
                                            // 修改自身密码
                                            System.out.print("请输入新密码: ");
                                            String newPassword = scanner.nextLine();
                                            if (changePassword(adminUsername, newPassword)) {
                                                System.out.println("密码修改成功！");
                                            } else {
                                                System.out.println("密码修改失败，请重试。");
                                            }
                                            break;

                                        case 2:
                                            // 重置用户密码
                                            System.out.print("请输入要重置密码的用户名: ");
                                            String resetUsername = scanner.nextLine();
                                            if (resetUserPassword(resetUsername)) {
                                                System.out.println(resetUsername + "密码重置成功！");
                                            } else {
                                                System.out.println("密码重置失败，用户不存在或发生错误。");
                                            }
                                            break;

                                        default:
                                            System.out.println("无效的选项，请重新输入。");
                                    }
                                    break;
                                case 2:
                                    // 用户管理
                                    System.out.println("用户管理功能:");
                                    System.out.println("1. 列出所有用户");
                                    System.out.println("2. 删除用户");
                                    System.out.println("3. 查询用户信息");
                                    System.out.println("4. 增加用户");
                                    System.out.println("5. 修改用户信息");
                                    System.out.print("请选择操作: ");
                                    int userChoice = scanner.nextInt();
                                    scanner.nextLine();  // 消耗掉输入缓冲区中的换行符

                                    switch (userChoice) {
                                        case 1:
                                            // 列出所有用户
                                            System.out.println("列出所有用户信息:");
                                            for (Map.Entry<String, String> entry : userPasswords.entrySet()) {
                                                System.out.println("用户名: " + entry.getKey() + ", 密码: " + entry.getValue());
                                            }
                                            break;
                                        case 2:
                                            // 删除用户
                                            System.out.print("请输入要删除的用户名: ");
                                            String deleteUser = scanner.nextLine();
                                            if (userPasswords.containsKey(deleteUser)) {
                                                userPasswords.remove(deleteUser);
                                                System.out.println(deleteUser + "删除成功！");
                                            } else {
                                                System.out.println("用户不存在，删除失败。");
                                            }
                                            break;
                                        case 3:
                                            // 查询用户信息
                                            System.out.print("请输入要查询的用户名: ");
                                            String queryUser = scanner.nextLine();
                                            if (userPasswords.containsKey(queryUser)) {
                                                System.out.println(queryUser + "的信息如下:");
                                                System.out.println("用户名: " + queryUser + ", 密码: " + userPasswords.get(queryUser));
                                            } else {
                                                System.out.println("用户不存在，查询失败。");
                                            }
                                            break;
                                        case 4:
                                            // 增加用户
                                            System.out.print("请输入新用户的用户名: ");
                                            String newUser = scanner.nextLine();
                                            if (!userPasswords.containsKey(newUser)) {
                                                System.out.print("请输入新用户的密码: ");
                                                String newPassword = scanner.nextLine();
                                                userPasswords.put(newUser, newPassword);
                                                System.out.println(newUser + "添加成功！");
                                            } else {
                                                System.out.println("用户已存在，添加失败。");
                                            }
                                            break;
                                        case 5:
                                            // 修改用户信息
                                            System.out.print("请输入要修改的用户名: ");
                                            String modifyUser = scanner.nextLine();
                                            if (userPasswords.containsKey(modifyUser)) {
                                                System.out.print("请输入新密码: ");
                                                String newPassword = scanner.nextLine();
                                                userPasswords.put(modifyUser, newPassword);
                                                System.out.println(modifyUser + "修改成功！");
                                            } else {
                                                System.out.println("用户不存在，修改失败。");
                                            }
                                            break;
                                        default:
                                            System.out.println("无效的选项，请重新输入。");
                                    }
                                    break;
                                case 3:
                                    System.out.println("管理员退出登录。");
                                    break;
                                default:
                                    System.out.println("无效的选项，请重新输入。");
                            }

                            if (adminChoice == 3) {
                                break;
                            }
                        }
                    } else {
                        System.out.println("登录失败，请检查用户名和密码。");
                    }
                    break;

                case 2:
                    // 经理登录
                    System.out.print("请输入经理用户名: ");
                    String managerUsername = scanner.nextLine();
                    System.out.print("请输入经理密码: ");
                    String managerPassword = scanner.nextLine();
                    if ("manager".equals(managerUsername) && "manager#123".equals(managerPassword)) {
                        System.out.println("经理登录成功！");
                        // 添加经理的 switch 语句
                        while (true) {
                            System.out.println("经理功能菜单:");
                            System.out.println("1. 统计数据");
                            System.out.println("2. 员工管理");
                            System.out.println("3. 退出登录");
                            System.out.print("请选择操作: ");
                            int managerChoice = scanner.nextInt();
                            scanner.nextLine();  // 消耗掉输入缓冲区中的换行符

                            switch (managerChoice) {
                                // ... （经理功能代码）
                                case 1:
                                    // 统计数据
                                    System.out.println("统计数据功能:");

                                    // 模拟一些统计数据
                                    int totalRevenue = 1000000;  // 总收入
                                    int totalTicketsSold = 50000;  // 总售票数
                                    int totalMovies = 20;  // 总上映电影数

                                    System.out.println("总收入: " + totalRevenue);
                                    System.out.println("总售票数: " + totalTicketsSold);
                                    System.out.println("总上映电影数: " + totalMovies);


                                    break;

                                case 2:
                                    // 员工管理
                                    System.out.println("员工管理功能:");
                                    System.out.println("1. 列出所有员工");
                                    System.out.println("2. 删除员工");
                                    System.out.println("3. 查询员工信息");
                                    System.out.println("4. 增加员工");
                                    System.out.println("5. 修改员工信息");
                                    System.out.print("请选择操作: ");
                                    int employeeChoice = scanner.nextInt();
                                    scanner.nextLine();  // 消耗掉输入缓冲区中的换行符

                                    switch (employeeChoice) {
                                        case 1:
                                            // 列出所有员工
                                            System.out.println("列出所有员工信息:");
                                            for (Map.Entry<String, String> entry : employeePasswords.entrySet()) {
                                                System.out.println("员工用户名: " + entry.getKey() + ", 密码: " + entry.getValue());
                                            }
                                            break;

                                        case 2:
                                            // 删除员工
                                            System.out.print("请输入要删除的员工用户名: ");
                                            String deleteEmployee = scanner.nextLine();
                                            if (employeePasswords.containsKey(deleteEmployee)) {
                                                employeePasswords.remove(deleteEmployee);
                                                System.out.println(deleteEmployee + "删除成功！");
                                            } else {
                                                System.out.println("员工不存在，删除失败。");
                                            }
                                            break;

                                        case 3:
                                            // 查询员工信息
                                            System.out.print("请输入要查询的员工用户名: ");
                                            String queryEmployee = scanner.nextLine();
                                            if (employeePasswords.containsKey(queryEmployee)) {
                                                System.out.println(queryEmployee + "的信息如下:");
                                                System.out.println("员工用户名: " + queryEmployee + ", 密码: " + employeePasswords.get(queryEmployee));
                                            } else {
                                                System.out.println("员工不存在，查询失败。");
                                            }
                                            break;

                                        case 4:
                                            // 增加员工
                                            System.out.print("请输入新员工的用户名: ");
                                            String newEmployee = scanner.nextLine();
                                            if (!employeePasswords.containsKey(newEmployee)) {
                                                System.out.print("请输入新员工的密码: ");
                                                String newPassword = scanner.nextLine();
                                                employeePasswords.put(newEmployee, newPassword);
                                                System.out.println(newEmployee + "添加成功！");
                                            } else {
                                                System.out.println("员工已存在，添加失败。");
                                            }
                                            break;

                                        case 5:
                                            // 修改员工信息
                                            System.out.print("请输入要修改的员工用户名: ");
                                            String modifyEmployee = scanner.nextLine();
                                            if (employeePasswords.containsKey(modifyEmployee)) {
                                                System.out.print("请输入新密码: ");
                                                String newPassword = scanner.nextLine();
                                                employeePasswords.put(modifyEmployee, newPassword);
                                                System.out.println(modifyEmployee + "修改成功！");
                                            } else {
                                                System.out.println("员工不存在，修改失败。");
                                            }
                                            break;

                                        default:
                                            System.out.println("无效的选项，请重新输入。");
                                    }
                                    break;
                                case 3:
                                    System.out.println("经理退出登录。");
                                    break;

                                default:
                                    System.out.println("无效的选项，请重新输入。");
                            }

                            if (managerChoice == 3) {
                                break;
                            }
                        }
                    } else {
                        System.out.println("登录失败，请检查用户名和密码。");
                    }
                    break;

                case 3:
                    // 前台登录
                    System.out.print("请输入前台用户名: ");
                    String receptionistUsername = scanner.nextLine();
                    System.out.print("请输入前台密码: ");
                    String receptionistPassword = scanner.nextLine();
                    if ("receptionist".equals(receptionistUsername) && "receptionist#456".equals(receptionistPassword)) {
                        System.out.println("前台登录成功！");
                        // 添加前台的 switch 语句
                        while (true) {
                            System.out.println("前台功能菜单:");
                            System.out.println("1. 售票");
                            System.out.println("2. 查询电影信息");
                            System.out.println("3. 退出登录");
                            System.out.print("请选择操作: ");
                            int receptionistChoice = scanner.nextInt();
                            scanner.nextLine();  // 消耗掉输入缓冲区中的换行符

                            switch (receptionistChoice) {
                                case 1:
                                    // 登录
                                    System.out.println("前台登录功能:");
                                    // 前台登录逻辑
                                    break;

                                case 2:
                                    // 退出
                                    System.out.println("前台退出登录。");
                                    break;

                                case 3:
                                    // 列出所有正在上映影片的信息
                                    System.out.println("列出所有正在上映影片的信息:");
                                    // 列出所有正在上映影片的信息的逻辑
                                    break;

                                case 4:
                                    // 列出所有场次的信息
                                    System.out.println("列出所有场次的信息:");
                                    // 列出所有场次的信息的逻辑
                                    break;

                                case 5:
                                    // 列出指定电影和场次的信息
                                    System.out.println("列出指定电影和场次的信息:");
                                    // 列出指定电影和场次的信息的逻辑
                                    break;

                                case 6:
                                    // 售票功能
                                    System.out.println("售票功能:");
                                    // 售票功能的逻辑，包括用户级别折扣计算等
                                    break;

                                default:
                                    System.out.println("无效的选项，请重新输入。");
                                    break;
                            }


                            if (receptionistChoice == 3) {
                                break;
                            }
                        }
                    } else {
                        System.out.println("登录失败，请检查用户名和密码。");
                    }
                    break;

                case 4:
                    // 用户登录
                    System.out.print("请输入用户名: ");
                    String userUsername = scanner.nextLine();
                    System.out.print("请输入密码: ");
                    String userPassword = scanner.nextLine();
                    userPasswords.put("user1", "password1");
                    userPasswords.put("user2", "password2");
// 继续添加其他用户信息...

                    if (userPasswords.containsKey(userUsername) && userPasswords.get(userUsername).equals(userPassword)) {
                        System.out.println("用户登录成功！");
                        // 添加用户的 switch 语句
                        while (true) {
                            System.out.println("用户功能菜单:");
                            System.out.println("1. 查询电影信息");
                            System.out.println("2. 购票");
                            System.out.println("3. 退出登录");
                            System.out.print("请选择操作: ");
                            int userChoice = scanner.nextInt();
                            scanner.nextLine();  // 消耗掉输入缓冲区中的换行符

                            switch (userChoice) {
                                // ... （用户功能代码）

                                case 3:
                                    System.out.println("用户退出登录。");
                                    break;

                                default:
                                    System.out.println("无效的选项，请重新输入。");
                            }

                            if (userChoice == 3) {
                                break;
                            }
                        }
                    } else {
                        System.out.println("登录失败，请检查用户名和密码。");
                    }
                    break;

                case 5:
                    System.out.println("退出系统。");
                    System.exit(0);
                    break;

                default:
                    System.out.println("无效的选项，请重新输入。");
            }
        }
    }
    private static boolean changePassword(String username, String newPassword) {
        // 模拟修改密码的逻辑
        if (userPasswords.containsKey(username)) {
            userPasswords.put(username, newPassword);
            return true;
        }
        return false;
    }

    private static boolean resetUserPassword(String username) {
        // 模拟重置用户密码的逻辑
        if (userPasswords.containsKey(username)) {
            // 重置密码为默认密码（你可以根据需要修改）
            userPasswords.put(username, "defaultPassword");
            return true;
        }
        return false;
    }

}

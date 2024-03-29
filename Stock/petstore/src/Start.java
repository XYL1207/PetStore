

import java.util.Scanner;

public class Start {
    public static void showStore(){
        System.out.println("==========    宠物商店    ==========");
        System.out.println("========== 1、查询宠物信息 ==========");
        System.out.println("========== 2、添加宠物信息 ==========");
        System.out.println("========== 3、删除宠物信息 ==========");
        System.out.println("========== 4、修改宠物信息 ==========");
        System.out.println("========== 5、登记宠物出售 ==========");
        System.out.println("========== 6、查询宠物出售 ==========");
        System.out.println("========== 0、退出宠物商店 ==========");
    }

    public static void receiveInfo(PetStore petStore){
        Scanner scanner = new Scanner(System.in);
        boolean exit = true;
        int storeOperate;
        while(exit){
            storeOperate = scanner.nextInt();
            // 增强性Switch - 新特性
            switch (storeOperate) {
                case 0 -> exit = false;
                case 1 -> selectPet(petStore, scanner);
                case 2 -> addPet(petStore, scanner);
                case 3 -> delPet(petStore, scanner);
                case 4 -> updPet(petStore, scanner);
                case 5 -> recordSell(petStore, scanner);
                case 6 -> selectSell(petStore, scanner);
                default -> System.out.println("输入错误请重试");
            }
        }
    }

    private static void selectSell(PetStore petStore, Scanner scanner) {
        int pet_id = inputPetID(scanner);
        String state = petStore.selectSell(pet_id);
        if (state != null){
            System.out.println("宠物出售状态" + petStore.selectSell(pet_id));
        } else {
            System.out.println("宠物不存在");
        }
    }

    private static void recordSell(PetStore petStore, Scanner scanner) {
        int pet_id = inputPetID(scanner);
        System.out.println("是否已经出售该宠物");
        String isSell = scanner.next();
        petStore.recordSell(pet_id,isSell);
        if (petStore.recordSell(pet_id,isSell)){
            System.out.println("登记成功");
        } else {
            System.out.println("宠物编号不存在，请重试！");
        }
    }

    private static void updPet(PetStore petStore, Scanner scanner) {
        int pet_id = inputPetID(scanner);
        Pet pet = new Pet();
        System.out.println("请需要修改的宠物信息：");
        System.out.print("姓名：");
        pet.setName(scanner.next());
        System.out.print("年龄：");
        pet.setAge(scanner.nextInt());
        System.out.print("性别：");
        pet.setSex(scanner.next());
        System.out.print("品种：");
        pet.setKind(scanner.next());
        System.out.print("是否防疫：");
        pet.setEpidemicPrevention(scanner.next());

        Pet upPet = petStore.updPet(pet_id,pet);
        if (upPet != null){
            System.out.println("修改成功，宠物信息如下：");
            System.out.println("编号：" + upPet.getId());
            System.out.println("姓名：" + upPet.getName());
            System.out.println("年龄：" + upPet.getAge());
            System.out.println("性别：" + upPet.getSex());
            System.out.println("品种：" + upPet.getKind());
            System.out.println("是否防疫：" + upPet.getEpidemicPrevention());
        } else {
            System.out.println("宠物编号不存在，请重试！");
        }
    }

    private static void delPet(PetStore petStore, Scanner scanner) {
        int pet_id = inputPetID(scanner);
        if (petStore.delPet(pet_id)){
            System.out.println("该宠物已被删除");
        } else {
            System.out.println("宠物编号不存在，请重试！");
        }
    }

    private static void addPet(PetStore petStore, Scanner scanner) {
        Pet pet = new Pet();
        System.out.println("请输入宠物信息：");
        System.out.print("编号：");
        pet.setId(scanner.nextInt());
        System.out.print("姓名：");
        pet.setName(scanner.next());
        System.out.print("年龄：");
        pet.setAge(scanner.nextInt());
        System.out.print("性别：");
        pet.setSex(scanner.next());
        System.out.print("品种：");
        pet.setKind(scanner.next());
        System.out.print("是否防疫：");
        pet.setEpidemicPrevention(scanner.next());
        if(petStore.addPet(pet)){
            System.out.println("添加成功");
        } else{
            System.out.println("添加失败");
        }
    }

    private static void selectPet(PetStore petStore, Scanner scanner) {
        int pet_id = inputPetID(scanner);
        Pet pet = petStore.selectPet(pet_id);
        if (pet != null){
            System.out.println("宠物信息如下：");
            System.out.println("编号：" + pet.getId());
            System.out.println("姓名：" + pet.getName());
            System.out.println("年龄：" + pet.getAge());
            System.out.println("性别：" + pet.getSex());
            System.out.println("品种：" + pet.getKind());
            System.out.println("是否防疫：" + pet.getEpidemicPrevention());
        } else {
            System.out.println("宠物编号不存在，请重试！");
        }
    }

    private static int inputPetID(Scanner scanner) {
        int pet_id;
        System.out.println("请输入宠物编号");
        pet_id = scanner.nextInt();
        return pet_id;
    }


    public static void main(String[] args) {
        PetStore petStore = new PetStore();
        showStore();
        receiveInfo(petStore);

    }
}


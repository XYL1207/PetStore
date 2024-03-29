import java.util.*;

public class PetStore {
    private ArrayList<Pet> arrayList;
    private Map<Integer,String> map;

    public PetStore() {
        this.arrayList = new ArrayList<>();
        this.map = new HashMap<>();
    }

    /**
     * 添加宠物进入商店
     * @return 商店中已存在id一致的宠物则返回false
     */
    public Pet selectPet(int pet_id){
        for (Pet pet : arrayList) {
            if (pet_id == pet.getId()){
                return pet;
            }
        }
        return null;
    }

    /**
     * 在商店中查询宠物信息
     * @return 商店中不存在该宠物则返回false
     */
    public boolean addPet(Pet pet){
        if(selectPet(pet.getId()) != null){
            return false;
        }
        arrayList.add(pet);
        map.put(pet.getId(),"否");
        return true;
    }

    /**
     * 将宠物从商店删除
     * @return 商店中若不存在该宠物id则返回false
     */
    public boolean delPet(int pet_id){
        Pet pet = selectPet(pet_id);
        if(pet == null){
            return false;
        }
        arrayList.remove(pet);
        map.remove(pet_id);
        return true;
    }

    /**
     * 将宠物信息修改
     * @return 商店中若不存在该宠物id则返回false
     */
    public Pet updPet(int pet_id,Pet changeInfo){
        Pet pet = selectPet(pet_id);
        if(pet == null){
            return null;
        }

        pet.setAge(changeInfo.getAge() == null ? pet.getAge() : changeInfo.getAge());
        pet.setKind(changeInfo.getKind() == null ? pet.getKind() : changeInfo.getKind());
        pet.setName(changeInfo.getName() == null ? pet.getName() : changeInfo.getName());
        pet.setSex(changeInfo.getSex() == null ? pet.getSex() : changeInfo.getSex());
        pet.setEpidemicPrevention(changeInfo.getEpidemicPrevention() == null ? pet.getEpidemicPrevention() : changeInfo.getEpidemicPrevention());
        return pet;
    }

    /**
     * 记录宠物是否售卖
     * @return 商店中若不存在该宠物id则返回false
     */
    public boolean recordSell(Integer pet_id,String str){
        if(selectPet(pet_id) == null){
            return false;
        }
        map.put(pet_id,str);
        return true;

    }

    /**
     * 查询宠物是否售卖
     * @return 商店中若不存在该宠物id则返回false
     */
    public String selectSell(Integer pet_id){

        return map.get(pet_id);

    }


}


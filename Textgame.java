import java.util.*;

public class Textgame {
    static int hero_level, hero_power, hero_hp, hero_defense, hero_mp, hero_experience, hero_money;
    static String hero_name;
    static String[] monster_names;
    static int[] monster_levels, monster_powers, monster_defenses, monster_hps, monster_experiences, monster_moneys;
    static int numOfMonsters;
    static int currentMonsterIndex; // 현재 전투 중인 몬스터의 인덱스

    // Hero Status method
    static void Status() {
        System.out.println("===== 영웅 상태창 =====");
        System.out.println("레벨: " + hero_level);
        System.out.println("힘: " + hero_power);
        System.out.println("방어력: " + hero_defense);
        System.out.println("HP: " + hero_hp);
        System.out.println("경험치: " + hero_experience);
        System.out.println("돈: " + hero_money);
        System.out.println("======================");
    }

    // 몬스터 초기화 메소드
    static void initializeMonsters() {
        // 몬스터 정보를 배열에 저장
        numOfMonsters = 3; // 몬스터 개수
        monster_names = new String[numOfMonsters];
        monster_levels = new int[numOfMonsters];
        monster_powers = new int[numOfMonsters];
        monster_defenses = new int[numOfMonsters];
        monster_hps = new int[numOfMonsters];
        monster_experiences = new int[numOfMonsters];
        monster_moneys = new int[numOfMonsters];

        // 몬스터 정보 설정
        monster_names[0] = "하급 주령";
        monster_levels[0] = 1;
        monster_powers[0] = 40;
        monster_defenses[0] = 5;
        monster_hps[0] = 500;
        monster_experiences[0] = 70;
        monster_moneys[0] = 5;

        monster_names[1] = "중급 주령";
        monster_levels[1] = 5;
        monster_powers[1] = 70;
        monster_defenses[1] = 15;
        monster_hps[1] = 1000;
        monster_experiences[1] = 150;
        monster_moneys[1] = 20;

        monster_names[2] = "특급 주령";
        monster_levels[2] = 10;
        monster_powers[2] = 100;
        monster_defenses[2] = 30;
        monster_hps[2] = 2000;
        monster_experiences[2] = 300;
        monster_moneys[2] = 30;
    }

    // 몬스터 전투 시작 메소드
    static void startBattleWithMonster() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("전투할 주령을 선택하세요:");
        for (int i = 0; i < numOfMonsters; i++){
            System.out.println((i + 1) + ". " + monster_names[i]);
        }
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice < 1 || choice > numOfMonsters) {
            System.out.println("잘못된 선택입니다.");
            return;
        }
        currentMonsterIndex = choice - 1;
        String currentMonsterName = monster_names[currentMonsterIndex];
        int currentMonsterLevel = monster_levels[currentMonsterIndex];
        int currentMonsterPower = monster_powers[currentMonsterIndex];
        int currentMonsterDefense = monster_defenses[currentMonsterIndex];
        int currentmonster_hp = monster_hps[currentMonsterIndex]; // 몬스터 체력 설정
        int currentMonsterExperience = monster_experiences[currentMonsterIndex];
        int currentMonsterMoney = monster_moneys[currentMonsterIndex];

        System.out.println("\n사냥터에 " + currentMonsterName + "가 나타났습니다!");

        while (hero_hp > 0 && currentmonster_hp > 0) {
            // 전투 로직
            int hero_damage = hero_level * 10 + hero_power * 30;
            int monster_damage = currentMonsterPower;

            if (hero_damage > currentMonsterDefense) {
                int damageDealt = hero_damage - currentMonsterDefense;
                currentmonster_hp -= damageDealt;

                System.out.println(hero_name + "가 " + currentMonsterName + "에게 " + damageDealt + " 데미지를 입혔습니다.");
            } else {
                System.out.println(currentMonsterName + "가 " + hero_name + "의 공격을 방어했습니다!");
            }

            if (monster_damage > hero_defense) {
                int damageTaken = monster_damage - hero_defense;
                hero_hp -= damageTaken;

                System.out.println(currentMonsterName + "가 " + hero_name + "에게 " + damageTaken + " 데미지를 입혔습니다.");

                if (hero_hp <= 0) {
                    hero_hp = 1; // 히어로 부활
                    System.out.println("히어로가 부활하였습니다!");
                    break; // 전투 종료
                }
            } else {
                System.out.println(hero_name + "가 " + currentMonsterName + "의 공격을 방어했습니다!");
            }
        }

    // 몬스터와의 전투가 종료되면 결과를 처리
    if (hero_hp > 0) {
        System.out.println(currentMonsterName + "가 죽었습니다!");
        hero_experience += currentMonsterExperience;
        hero_money += currentMonsterMoney;

        // 히어로 레벨업 처리
        if (hero_experience >= hero_level * 80) {
            hero_level++;
            System.out.println("축하합니다! " + hero_name + "가 레벨 " + hero_level + "로 올랐습니다.");
            hero_money += hero_level * 50;
            System.out.println("레벨업 기념으로 돈이 " + hero_level * 50 + " 증가했습니다.");
            hero_experience = 0; // 경험치 초기화

            //레벨업 시 HP 회복
            hero_hp = 80;
        }
    } else {
        hero_hp = 1; // 히어로 부활
        System.out.println("히어로가 부활하였습니다!");
    }

    // 전투가 종료되었으므로 사용자 입력을 다시 받을 수 있도록 메시지 출력
    System.out.println("전투가 종료되었습니다. 다시 선택하세요.");
}

    static void PotionStore() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("===== 상점 =====");
        
        int potionStrengthPrice = 20;
        int potionDefensePrice = 20;
        int potionExperiencePrice = 30;
        int potionHPPrice = 30;
        int potionMPPrice = 30;

        System.out.println("1. 힘 증강 포션 - 가격: " + potionStrengthPrice);
        System.out.println("2. 방어력 증강 포션 - 가격: " + potionDefensePrice);
        System.out.println("3. 경험치 포션 - 가격: " + potionExperiencePrice);
        System.out.println("4. HP 증강 포션 - 가격: " + potionHPPrice);
        System.out.println("5. MP 증강 포션 - 가격: " + potionMPPrice);
        System.out.println("6. 나가기");

        int shopChoice = scanner.nextInt();
        scanner.nextLine();

        if (shopChoice == 6) {
            System.out.println("상점을 나갑니다.");
        } else if (shopChoice < 1 || shopChoice > 5) {
            System.out.println("잘못된 선택입니다.");
        } else {
            int selectedPotionPrice = 0;
            String selectedPotionType = "";

            switch (shopChoice) {
                case 1:
                    selectedPotionPrice = potionStrengthPrice;
                    selectedPotionType = "힘 증강 포션";
                    hero_power += 5; // 힘 증강 포션 사용 - 영웅의 힘을 5 증가 
                    break;
                case 2:
                    selectedPotionPrice = potionDefensePrice;
                    selectedPotionType = "방어력 증강 포션";
                    hero_defense += 5; // 방어력 증강 포션 사용 - 영웅의 방어력을 5 증가 
                    break;
                case 3:
                    selectedPotionPrice = potionExperiencePrice;
                    selectedPotionType = "경험치 포션";
                    hero_experience += 50; // 경험치 포션 사용 - 영웅의 경험치를 50 증가
                    break;
                case 4:
                    selectedPotionPrice = potionHPPrice;
                    selectedPotionType = "HP 증강 포션";
                    hero_hp += 50; // HP 증강 포션 사용 - 영웅의 HP를 50 증가
                    break;
                case 5:
                    selectedPotionPrice = potionMPPrice;
                    selectedPotionType = "MP 증강 포션";
                    hero_mp += 50; // MP 증강 포션 사용 - 영웅의 MP를 50 증가
                    break;
            }

            if (hero_money < selectedPotionPrice) {
                System.out.println("돈이 부족합니다.");
            } else {

                hero_money -= selectedPotionPrice; // 영웅의 돈에서 포션 가격 차감
                System.out.println(hero_name + "가 " + selectedPotionType + "를 구매했습니다.");
            }
        }
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("영웅의 이름을 입력하세요: ");
        hero_name = scanner.nextLine();
        System.out.println("이름이 입력되었습니다");
        System.out.println("게임에 입장하였습니다");

        // Hero default value setting
        hero_level = 1;
        hero_power = 15;
        hero_defense = 25;
        hero_hp = 80;
        hero_experience = 0;
        hero_money = 0;

        initializeMonsters(); // 몬스터 정보 초기화

        while (hero_hp > 0) { // 영웅이 살아 있는 동안 게임 진행
            Status();

            System.out.println("\n사냥터에 입장하였습니다!");
            System.out.println("1. 몬스터와 전투하기");
            System.out.println("2. 상점으로 이동하기");
            System.out.println("3. 게임 종료");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    startBattleWithMonster(); // 몬스터와 전투
                    break;
                case 2:
                    System.out.println("\n상점으로 이동하였습니다.");
                    PotionStore();
                    break;
                case 3:
                    System.out.println("게임을 종료합니다.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("올바른 선택지를 입력하세요.");
            }
        }

        System.out.println("게임을 종료합니다.");
        scanner.close();
    }
}

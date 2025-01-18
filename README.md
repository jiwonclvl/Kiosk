# Kiosk
- **Java 언어**를 활용한 `키오스크 프로그램`이다. 
- 콘솔에서 **메인 메뉴**를 선택하면 해당 메인 메뉴의 **하위 메뉴들**를 선택할 수 있고 선택한 항목을 장바구니에 담아 주문할 수 있는 키오스크 프로그램을 제작했다. 
- **level6**을 기준으로 Readme를 작성하였다.

<br>

## 목차 [Table of Contents]

- [메뉴 소개 [Kiosk Menu]](#메뉴-소개-kiosk-menu)
- [주요 기능 [Features]](#주요-기능-features)
- [프로젝트 실행 순서 [Execution Steps]](#프로젝트-실행-순서-execution-steps)
- [입력 예외 처리 [Exception Handling]](#입력-예외-처리-exception)
- [파일 구조 [Architecture]](#파일-구조-Architecture)
- [Notes](#notes)

<br>

## 메뉴 소개 [Kiosk Menu] 

### 📋 Main Menu 📋 

**Burger, Drink, Dessert** 3가지의 메뉴가 존재한다. 

<br>

![image](https://github.com/user-attachments/assets/adeea48e-1ce4-4b90-98a7-c937d7e9b7c0)

<br>

### 📋 Sub Menu 📋

메인 메뉴마다 **4가지의 하위 메뉴**를 가진다.
<details><summary>Burger🍔
</summary>

<br>

![image](https://github.com/user-attachments/assets/a10d644d-1e3c-4e46-8d72-0191b2fc3a2a)

</details>

<br>

<details><summary>Drink🍹
</summary>

<br>

![image](https://github.com/user-attachments/assets/45363531-14ac-4f82-b069-77f0b5e4107c)

</details>

<br>

<details><summary>Dessert🧁
</summary>

<br>

![image](https://github.com/user-attachments/assets/7a352e7b-9c25-4a33-9762-59cced3322ad)

</details>

<br>

## 주요 기능 [Features]
- **메뉴 선택 기능 ✔️** <br>
  - 사용자는 제공된 메뉴 항목에서 **원하는 메뉴를 선택**할 수 있다. (모든 입력은 숫자로만 이루어진다.)
  - 선택된 메뉴는 `장바구니에 저장`되며 각 메뉴의 `정보(이름, 가격, 설명)가 장바구니에 추가`된다.
  - 장바구니에 **동일한 메뉴를 여러번 추가**할 수 있고 각 선택은 `별도로 저장된다.`
 
<br>

- **장바구니 기능 🛒** <br>
   - 장바구니에는 `해당 메뉴의 정보`와 `총 금액`이 출력된다.
   - 사용자는 원할 경우 `장바구니를 초기화`하여 비울 수 있다.
 
<br>

- **할인 기능 %** <br>
  - 사용자의 **직업(국가 유공자, 군인, 학생, 일반) 정보**를 입력할 수 있다. 
  -  입력된 직업에 따라 **미리 정의된 할인률**이 적용되어 `최종 결제 금액`이 계산된다. 


<br>

## 프로젝트 실행 순서 [Execution Steps]
1. **메인 메뉴 선택** <br>

- 사용자가 메인 메뉴에 해당하는 **숫자를 입력**하면 해당 메뉴와 관련된 `하위 메뉴들이 출력된다.`
  
   ![image](https://github.com/user-attachments/assets/3fb0656f-eab5-4689-b449-80473f1d6e0a)

   <br>

2. **하위 메뉴 선택** <br>

- 사용자가 원하는 **하위 메뉴 선택**하면, 해당 메뉴의 `정보를 출력하고 장바구니 담을지 여부`를 물어본다.  

   ![image](https://github.com/user-attachments/assets/7381dafb-9c37-441a-8c82-c0b4cdda3762)


 <br>

3. **장바구니 담기** <br>

- **장바구니에 담기를 희망**하면 `1`, **희망하지 않으면** `2`를 눌러 장바구니에 담을지 말지 결정한다.
  
     ![image](https://github.com/user-attachments/assets/0211219d-13a1-479c-a496-fd2cb9d831ec)


    <br>

 - 장바구니에 메뉴를 담으면 메인 메뉴 선택 화면으로 돌아가며, `Order Menu가 새로 생성`된다.
     
      ![image](https://github.com/user-attachments/assets/cc2d2f00-1f7e-48ab-a630-8bc104b47fc6)

    

<br>

4. **장바구니에 담긴 메뉴 출력 및 주문하기** <br>

 - 위의 `4 : Orders`를 누를 시 장바구니에 **담긴 메뉴와 총 금액**이 출력된다.
     
     ![image](https://github.com/user-attachments/assets/a5f7cd34-69e6-4f45-b2f8-7b1e061bbf16)


    <br>
   
 - 이후 `1 : 주문`을 누르면 **사용자의 직업을 선택**하는 항목이 출력된다.
    
     ![image](https://github.com/user-attachments/assets/b8e15d84-d7a3-4359-bff3-ee232ea0cde4)

 <br>

 5. **할인률 적용 후 총 금액 출력하기** <br>

- 사용자가 입력한 **직업에 따라 할인률이 적용**되어 `총 금액이 출력된다.`
    
     ![image](https://github.com/user-attachments/assets/2fddf7ae-90bd-4ba5-8c94-9a784ad5d585)

<br>

6. **장바구니 초기화 및 초기 화면 시작** <br>

- 주문이 완료되면 장바구니는 다시 초기화 되고 메인 메뉴 선택화면이 출력된다.
    
     ![image](https://github.com/user-attachments/assets/eb2a5595-7a27-4336-a07f-c358ccfeea10)

 

<br>

## 입력 예외 처리 [Exception]
잘못된 입력 시 경고 문자 출력 후 다시 메뉴 입력을 요구한다. **(모든 선택 부분에 동일하게 적용된다.)**
<br>

- **메뉴에 주어진 항목 외의 숫자를 누른 경우** <br>

   ![image](https://github.com/user-attachments/assets/64d07595-6842-4ecf-abee-b5e4394e62da)


  <br>

- **문자를 입력한 경우**

   ![image](https://github.com/user-attachments/assets/9be2e669-9209-4368-8134-532f2f3b803b)


<br>

## 파일 구조 [Architecture]

```
level6/
├──  main
│   └── Main.java             # App 시작
├── menu/
│   ├── Menu.java             # 메뉴의 카테고리를 관리
│   └── MenuItem.java         # 메인 메뉴의 하위 항목 관리
├── cart/
│   └── Cart.java             # 장바구니 관리
├── kiosk/
│   ├── Kiosk.java            # 키오스크 시스템의 진입점
│   ├── KioskView.java        # 화면의 출력 및 UI 관리
│   └── KioskController.java  # 사용자 입력 처리 및 기능 로직 관리
├── user/
│   └── UserType.java         # 사용자 유형 관리
└── exception/
    └── CustomException.java  # 사용자 입력에 대한 예외 처리 
```

<br>

## Notes
<br>

- 본 프로젝트는 Java 프로그래밍 기초 및 예외 처리, 클래스 활용 학습을 목적으로 제작하였다. 

  


   

   


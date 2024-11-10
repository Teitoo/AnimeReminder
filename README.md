# AnimeReminder
small side-project

## 後端

* Java
* Spring Boot
* ~~MongoDB(Not Sure)~~
* MySQL

## 前端

* ~~Angular/Vue/React~~
* Vue

## Extra

* 希望佈署到Docker中
* Unit Test

## 主要功能

* 使用者 輸入/勾選 想要追的新番
* 資料來源：月初手動加入資料庫/使用者提供資料
* 當新番更新時，確認使用者有無加入追番清單
  * 有：發出通知(email/chatBot)
  * 沒有：沒事

## Progress

* 後端
  - [ ] 使用者
    
    * ID
    * 名字
    * 帳號(email)密碼
    * 追番列表

  - [ ] 新番
    
    * ID
    * 新番名稱
    * 季節
    * 更新時間

  * Service

    - [ ] CRUD
    - [ ] 使用者和新番的交互邏輯
    - [ ] 新番在確認時間後發送通知

  - [ ] SQL

  

* 前端
    
    - [ ] 前到後的資料傳遞
    - [ ] 畫面


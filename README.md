# 追番助理

## 後端

* Java
* Spring Boot
* ~~MongoDB(Not Sure)~~
* MySQL

## 前端

* ~~Angular/Vue/React~~
* ~~Vue~~
* LINE chatBot

## Extra

* 希望佈署到Docker中
* Unit Test

## 主要功能

* 每個LINE帳號 一個Profile
* 使用者 輸入 想要追的新番
* 資料來源：~~月初手動加入資料庫~~/使用者提供資料
* 當新番更新時，確認使用者有無加入追番清單
  * 有：發出通知(chatBot)
  * 沒有：沒事

## Progress

* 後端
  - [x] 使用者
    
    * ID
    * 名字
    * 帳號(email)
    * ~~密碼~~
    * 追番列表

  - [x] 新番
    
    * ID
    * 新番名稱
    * 季節
    * 更新時間

 - [ ] message

  * Service

    - [x] CRUD
    - [ ] 使用者和新番的交互邏輯
    - [ ] 新番在確認時間後發送通知

  - [ ] SQL

* 前端
    
    - [ ] 前到後的資料傳遞
    - [ ] 畫面


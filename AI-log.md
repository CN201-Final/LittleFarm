# AI Usage Log — Little Farm Project
# AI Usage Log — Little Farm Project
* **เครื่องมือ AI ที่ใช้:** Google Gemini, ChatGPT

---
## (Usage Log)
### 1. การทำ UI หน้าจอ TV และ Effect สภาพอากาศ 
* **Prompt:** ช่วยสร้าง UI หน้าต่าง TvScreen, effect ตอนฝนตกหนักและมีฟ้าแลบ, TV ใน FarmScreen
* **ผลลัพธ์ที่ได้จาก AI:** ได้ฟังก์ชัน draw() ในการวาดหน้าต่างใน TvScreen, การปรับฝนให้ตกหนักขึ้นและจอกระพริบ
* **ปรับแก้:** ปรับพิกัด (x, y) ขนาดกรอบ และโทนสีให้เข้ากับ UI ของเกม 

### 2. Refactoring, Code Smell
* **Prompt:** ช่วยหาจุดที่เป็น Code Smell 
* **ผลลัพธ์ที่ได้จาก AI:** การทำ calculatePrice(Crop crop, Season season) ในการคำนวณเงินที่จะได้หลัง Ship
* **ปรับแก้:** ได้ Idea แยก Abstact Class Season ออกมาพร้อมให้ HotSeason, RainySeason, ColdSeason เป็นคลาสสืบทอด
ทำให้หากต้องการสร้างฤดูใหม่จะทำได้ง่ายกว่าแบบเขียน nested loop ใน Weather.java

### 3. Class Diagram & Exception Family
* **Prompt:** ช่วยสร้าง Class Diagram และ Exception Family ใน mermaid ได้ไหม
* **ผลลัพธ์ที่ได้จาก AI:** 
![Class Diagram](image/Class%20Diagram%20cn201.png)
![Class Diagram](image/Exception%20Family.png)
* **ปรับแก้:** Diagram ที่ได้จาก AI เล็กน้อย เพราะ Attribute กับ Method ไม่ค่อยตรงกับไฟล์ src เช่น ใน Class Season ไม่ได้เขียน method getToolSurcharge() ในตอนแรก

### 4. Strategy 
* **Prompt:** ช่วยทำให้ฤดูกลายเป็น Strategy ได้ไหม
* **ผลลัพธ์ที่ได้จาก AI:** ได้ Code ที่เข้ามาปรับโครงสร้าง Main.java, แก้ Constructor ของ GamePanel.java,สร้างไฟล์ SeasonFactory.java
* **ปรับแก้:** การเขียนเพิ่ม switch case "season" ใน SaveGame.java เพื่อให้เมื่อออกเกมแล้ว ฤดูยังเซฟอยู่เ
---


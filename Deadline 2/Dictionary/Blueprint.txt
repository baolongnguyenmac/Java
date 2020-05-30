=================================================================
*************************** CHỨC NĂNG ***************************
=================================================================

1. chuyển đổi ngôn ngữ tra cứu
2. tra cứu và hiển thị nghĩa
3. thêm từ + nghĩa vào từ điển
4. xoá từ và nghĩa ra khỏi từ điển
5. lưu lại danh sách từ yêu thích và sort theo thứ tự A-Z/Z-A
6. Thống kê tần suất của các từ đã tra từ ngày date1 -> date2

=================================================================
*************************** PHÁC THẢO ***************************
=================================================================

- đọc file từ điển 
    + class Reader
    + nhận vào 1 bool isAnh_Viet? trả về 1 arrayList

- ghi file từ điển
    + class reader 
    + nhận vào 1 bool isAnh_Viet?

- đọc file lịch sử 
    + class reader
    + trả về 1 arrayList

- ghi file lịch sử 
    + class Writer

- class lịch sử tra cứu 
    + class HistoryItem {
        Word
        Date
    }
    + class History.java -> singleton 
        * final fileName
        * arrayList<HistoryItem>
        * lưu file xml dạng này luôn :)

- đọc file từ yêu thích 
    + class reader 
        * final fileName
        * trả về arrayList<Word>

- ghi file từ yêu thihcs
    + class Writer

- class từ yêu thích -> singleton 
    + class Favorite.java 
        * arrayList<Word>
        * sort A-Z/Z-A 
        * final fileName


=================================================================
*************************** THIẾT KẾ ****************************
=================================================================

0. Ý tưởng 
    Khi chương trình bắt đầu chạy: cho người dùng chọn loại từ điển và load từ điển đó vào đối tượng MyDictionary
        1. Chọn từ điển tra cứu Anh - Việt
            1. Nhập từ để tra cứu
                > <nhập từ tại đây>
                // sau khi nhập và nhấn enter
                    + nếu từ không tồn tại 
                        - xuất thông báo: từ không tồn tại 
                        - bạn muốn thêm từ vào từ điển (y/n)
                    + nếu từ tồn tại 
                        - bạn muốn thêm vào danh sách từ yêu thích (y/n)

            2. Thêm từ vào từ điển 
                > <Nhập từ tại đây>
                // sau khi đã nhập và nhấn enter
                    + nếu đã tồn tại trong từ điển: xuất thông báo: từ đã tồn tại 
                    + nếu k tồn tại trong từ điển: 
                        - bắt nhập nghĩa của từ vừa tra 
                        - thông báo thành công 
            0. Trở về 
        2. Chọn từ điển tra cứu Việt - Anh (same Anh - Việt)
        3. Lịch sử tra cứu 
            - nhập ngày bắt đầu 
            - nhập ngày kết thúc 
            // sau khi đã nhập ngày và nhấn enter
                + kiểm tra tính hợp lệ của date1 và date2
                + đọc kiểm tra file lịch sử 
                + xuất kq
        0. Thoát

1. Thiết kế package com.java.model
    1.1. MyDictionary.java gồm 1 treeMap chứa các từ trong từ điển 
    1.2. WordList.java gồm 1 arrayList chứa các từ trong từ điển và các annotation phục vụ cho việc đọc ghi file
    1.3. Word.java gồm String _word và String _meaning chứa từ và nghĩa từ. Các annotation để đọc ghi file 

2. Thiết kế package com.java.handlefile
    |===========================================================================|
    |lưu ý: file dữ liệu dạng xml phải được mã hoá dưới dạng UTF-8 (without bom)|
    |===========================================================================|

    2.1. Writer.java ghi dữ liệu xuống file 
    2.2. Reader.java đọc dữ liệu từ file 

3. Thiết kế com.java.main 
    3.1. Main.java chứa hàm main để chạy chương trình
    3.2. Loader.java khởi tạo các dữ liệu cho chươn trình
    3.3. Saver.java lưu data cho toàn bộ chương trinhd 
    3.4. Menu.java chạy menu dạng console cho chươn trình 

==================================================================
*************************** PROTOTYPE ****************************
==================================================================

1. package com.java.model
    1.1. Word         // just a few properties, constructor (optional), setter and getter
    1.2. WordList     // just a few properties, constructor (optional), setter and getter
        - cài đặt bằng singleton
        - public void setList(TreeMap<String, String>)
    1.3. MyDictionary // just a few properties, constructor (optional), setter and getter
            - public void searchWord()
            - private Word searchWord(String word)
        - public void addWord()
        - private void addWord(TreeMap<String, String>, Word)
            - public void deleteWord()
            - public void deleteWord(TreeMap<String, String>, Word)
    1.4. History @XmlRootElement (name = "History")
        - singleton
        - arrayList<HistoryItem> @XmlElement(name = "list")
            - public void statisticWord()
            - private arrayList<HistoryItem> statisticWord(date1, date2)
        - public static History getHistory()
            - private void addHistoryItem(HistoryItem) -> ghi file ngay và luôn 
            - public void addHistoryItem(Word)
        - public void printHistory()
        
    1.5. Favorite @XmlRootElement (name = "Favorite")
        - singleton
        - arrayList<Word>
        - public void addFavorite(Word) -> ghi file ngay và luôn 
        - public void sort(bool isAZ?)
        - private void sort(bool isAZ, arrayList<Word>)
        - public void printFavorite()

2. package com.java.handlefile
    2.1. Writer.java
        - public void writeDictionary(bool isAnh_Viet?): 
            + chuyển cây sang arrayList
            + ghi tù mới (từ WordList) vào trong file từ điển
        - public void writeHistory(): ghi thẳng vào file từ arrayList của History
        - public void writeFavorite(): ghi thẳng vào file từ arrayList của Favorite
    2.2. Reader
        - public void readDictionary(bool isAnh_Viet?): 
            + đọc từ from file từ điển vào WordList
            + gán WordList vào treeMap
        - public void readHistory(): đọc thằng vào arraylist của History
        - public void readFavorite(): đọc thằng vào arraylist của Favorite

3. package com.java.main
    3.1. Loader.java (gọi lại các hàm của Reader.java)
        - private loadDictionary(bool isAnh_Viet?)
        - private loadHistory()
        - private loadFavorite()
        - public loadData(): gọi lại các hàm private bên trên :v
    3.2. Saver.java (gọi lại các hàm của Writer)
        - private saveDictionary(bool isAnh_Viet?)
        - private saveHistory()
        - private saveFavorite()
        - public save(): gọi lại các hàm private bên trên 

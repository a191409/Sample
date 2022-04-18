//  自分が格納されているフォルダ名
package beans;

import java.sql.Date;

public class Task {

    // 属性
    private int id = 0;
    private String name = null;
    private String description = null;
    private java.sql.Date limit = null;
    private int didit = 0;//0は未実施,1は実施済み
    private int category_id = 0;
    private String category_name = null;
    private int user_id = 0;
    // 初期値を引数に持ったコンストラクタ
    public Task(int id,String name,String description,Date limit,int didit,int category_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.limit = limit;
        this.didit = didit;
        this.category_id = category_id;
    }
    public Task(int id,String name,String description,Date limit,int didit,int category_id,String category_name,int user_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.limit = limit;
        this.didit = didit;
        this.category_id = category_id;
        this.category_name = category_name;
        this.user_id = user_id;
    }
    public Task(int id){
        this.id = id;
    }
    // 初期値を引数に持たないコンストラクタ
    // Java beansは初期値を持たないコンストラクタが必ず必要
    public Task() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription(){
        return description;
    }

    public  void setDescription(String description){
        this.description = description;
    }

    public java.sql.Date getLimit() {
        return limit;
    }

    public void setLimit(Date limit) {
        this.limit = limit;
    }

    public int getDidit() {
        return didit;
    }

    public void setDidit(int didit) {
        this.didit = didit;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name(){ return category_name; }

    public void setCategory_name(String category_name) { this.category_name = category_name; }

    public int getUser_id() { return user_id; }

    public void setUser_id(int user_id) { this.user_id = user_id; }
}
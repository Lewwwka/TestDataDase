public class Main {
    public static void main(String[] args){
        DBTest dbTest = new DBTest();
        //Вызываем метод Select для получения данных из таблицы в БД
        dbTest.select();
        //Вызываем метод Insert для вставки строки в таблицу БД
        //dbTest.insert();
    }
}

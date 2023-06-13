/*Lesson3_Chapter10_課題：ストリーム処理
課題3で作成したTaskクラス(修正必要)と、mainメソッドを持ち、ストリーム、ラムダ式、メソッド参照を盛り込んだクラスを使用してストリーム処理を行う。 */

import java.time.LocalDate;

//Comparableインタフェースを実装する(比較処理→並べ替えに必要)
public class Task implements Comparable<Task> {
	//メンバー変数
	private LocalDate date;
	private String task;
	private boolean done; // 追加　完了はtrue, 未完了は false
	//コンストラクタで値を変数に代入
	public Task(LocalDate date, String task, boolean done) {
		this.date = date;
		this.task = task;
		this.done = done;
	}
	
	//日付のgetterメソッド
	public LocalDate getDate() {
		return date;
	}
	//タスクのgetterメソッド
	public String getTask() {
		return task;
	}
	
	// boolean型のgetterメソッドはis～とすることもある
	public boolean isDone() {
		return done;
	}
	
	// compareToメソッド(大小比較)をオーバーライドする
	// 日付で並び替えるため、LocalDateでcompareToを行う
	@Override
	public int compareTo(Task t) {
		return this.date.compareTo(t.date);  //比較するもの.compareTo(比較されるもの)
	}
	
	//変数出力時に適用されるメソッド
	@Override
	public String toString() {
		return this.date + " " + this.task;
	}
}

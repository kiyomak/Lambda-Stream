/*Lesson3_Chapter10_課題：ストリーム処理を使わない場合
・実行結果の表示に含まれる内容
1. 未完了のタスクの個数を表示
2. 未完了のタスク一覧を日時の昇順に並べて表示
[ 実行結果 ]
未完了のタスクの個数は3
【未完了のタスクを昇順に並び替えて一覧表示】
2021-08-10 散髪に行く
2021-09-15 ○○社面接
2021-11-09 スクールの課題を解く */


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//ストリーム処理、中間と終端はfor文が内部的にされていると考えること！


public class Hoge{
	public static void main(String[] args) throws Exception {
		List<Task> list = new ArrayList<Task>();
		//日付、タスク、完了(true)または未完了(false)
		list.add(new Task(LocalDate.of(2021, 10, 21), "牛乳を買う", true));
		list.add(new Task(LocalDate.of(2021, 9, 15), "○○社面接", false));
		list.add(new Task(LocalDate.of(2021, 12, 4), "手帳を買う", true));
		list.add(new Task(LocalDate.of(2021, 8, 10), "散髪に行く", false));
		list.add(new Task(LocalDate.of(2021, 11, 9), "スクールの課題を解く", false));
		
		//未完了タスク用のリストをつくる
		List<Task> falselist = new ArrayList<Task>();
		//拡張for文でfruitsをループする
		 for(Task falseTask : list ){
			//未完了のタスクの場合は、falselistに追加していく→未完了のタスクのみリストfalselistに取り出される。
			if( falseTask.isDone() == false){
			falselist.add(falseTask);
			}
		}
		 
		 System.out.println("未完了のタスクの個数は " + falselist.size());
		 System.out.println("【未完了のタスクを昇順に並び替えて一覧表示】");
				 
		 //未完了タスクを日付順に並び替える
		 // for文で、比較をつくる
		 //sortメソッドの引数は、「Comparatorインタフェースを実装したクラスのインスタンス」を渡さないといけない
		 //sortメソッドは、【Collections】クラスのメソッドなので、使えるようにインポート必要
	
		 for( Task dateTask: falselist ) {
			 		//無名クラスを利用
				 // sortメソッド(並び替え)の引数内に、Comparableインターフェース作成
	Comparable<Task> ttt=	new Comparable<Task>(){
					 @Override
					 public int compareTo(Task f2) {
						 return dateTask.compareTo(f2);
					 }
					 
				 };

		 }
		 
		for(Task b : falselist) {
			System.out.println(b);
		}
		
		 
	        
	}
}

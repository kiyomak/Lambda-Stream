/*Lesson3_Chapter10_課題：ストリーム処理
課題3で作成したTaskクラスとmainメソッドを持ち、ストリーム、ラムダ式、メソッド参照を盛り込んだクラスを使用してストリーム処理を行う。
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

public class Chapter10 {
	public static void main(String[] args) throws Exception {
		List<Task> list = new ArrayList<Task>();
		//日付、タスク、完了(true)または未完了(false)
		list.add(new Task(LocalDate.of(2021, 10, 21), "牛乳を買う", true));
		list.add(new Task(LocalDate.of(2021, 9, 15), "○○社面接", false));
		list.add(new Task(LocalDate.of(2021, 12, 4), "手帳を買う", true));
		list.add(new Task(LocalDate.of(2021, 8, 10), "散髪に行く", false));
		list.add(new Task(LocalDate.of(2021, 11, 9), "スクールの課題を解く", false));
		
		// 以下記述
		//①ストリームを生成する
		long count=list.stream()
								//②中間操作：未完了のタスクの個数を抽出する
/*①通常の書き方
	List<Task> falselist = new ArrayList<Task>();
	//拡張for文でfruitsをループする
	 for(Task falseTask : list ){
		//未完了のタスクの場合は、falselistに追加していく→未完了のタスクのみリストfalselistに取り出される。
		if( falseTask.isDone() == false){
		falselist.add(falseTask);
		}
	}		        	      		
	*/
				/* ??①のif文をラムダ式にして、 .filter()メソッドにいれる。 
				　※(拡張for文は、 .forEach()で表す)
				 ラムダ式を適用すif文を振り分けると、
				 ①	 if( falseTask.isDone() == false)という条件を判断してbooleanを返すメソッドを作成する。
								public boolean p(Task falseTask){
								return falseTask.isDone() == false;
								}

				 ②①を、ラムダ式の（引数）->{メソッド内の処理内容｝;にする
				 (Task falseTask)->{return falseTask.isDone() == false; };
				 
				 ③よりラムダ式を簡略したもの
				 falseTask -> falseTask.isDone() == false;
				 
				 ④③を、sort（並び替え）の中間操作：要素を条件で絞り込むfilterメソッドの引数にいれると、falseTaskの処理内容falseTask.isDone() == falseが抽出条件になり、falseの分だけfalselist変数のListに入る。
				 sort .filter（中間操作）はfor文を使わないで繰り返し作業をしている形
			 */
								.filter(falseTask -> falseTask.isDone() == false )

								//③終端操作：要素数を数える
								.count();
		System.out.println("未完了のタスクの個数は" + count);
		System.out.println("【未完了のタスクを昇順に並び替えて一覧表示】");
		
		//未完了のタスクを昇順に並べ替える
		list.stream()
			//中間操作①未完了のタスクの個数を抽出する（繰り返しを行っている）
			.filter(falseTask -> falseTask.isDone() == false )

			//中間操作②未完了のタスク一覧を日時の昇順に並べる
			.sorted((false1,false2) -> false1.compareTo(false2) )
			//終端操作：出力する→各要素を順に処理していくforEachで要素を全部出す
			
			.forEach(System.out::println);
	        
	}
}




/*
----メンターさんの評価ポイント----
・要件通りに機能しています。
・未完了のタスクの個数の抽出にストリーム処理を実装できています。
・未完了のタスク一覧の並び替えにストリーム処理を実装できています。
・インデントが揃ったきれいなコードが書けています。


----(模範解答)---------------------------------

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Chapter10 {
    public static void main(String[] args) throws Exception {
        List<Task> list = new ArrayList<>();
        list.add(new Task(LocalDate.of(2021, 10, 21), "牛乳を買う", true));
        list.add(new Task(LocalDate.of(2021, 9, 15), "○○社面接", false));
        list.add(new Task(LocalDate.of(2021, 12, 4), "手帳を買う", true));
        list.add(new Task(LocalDate.of(2021, 8, 10), "散髪に行く", false));
        list.add(new Task(LocalDate.of(2021, 11, 9), "スクールの課題を解く", false));

        // 未完了のタスクの個数を出力
        long count = list.stream().filter(t -> !t.isDone()).count();
        System.out.println("未完了のタスクの個数は" + count);
        System.out.println("【未完了のタスクを昇順に並び替えて一覧表示】");
        // 日付順に昇順に並び替えたタスクのリストを表示
        list.stream().filter(t -> !t.isDone()).sorted().forEach(System.out::println);

    }
}
-----
 
 */
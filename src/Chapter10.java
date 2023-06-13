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
					        	.filter(falseTask -> falseTask.isDone() == false )
					        	//③終端操作：要素数を数える
					        	.count();
        System.out.println("未完了のタスクの個数は" + count);
        System.out.println("【未完了のタスクを昇順に並び替えて一覧表示】");
        
        //未完了のタスクを昇順に並べ替える
        list.stream()
             //中間操作①未完了のタスクの個数を抽出する
            .filter(falseTask -> falseTask.isDone() == false )
            //中間操作②未完了のタスク一覧を日時の昇順に並べる
        	.sorted((false1,false2) -> false1.compareTo(false2) )
        	//終端操作：出力する
        	.forEach(System.out::println);
        
    }
}


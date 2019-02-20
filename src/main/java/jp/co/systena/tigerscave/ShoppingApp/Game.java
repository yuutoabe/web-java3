package jp.co.systena.tigerscave.ShoppingApp;

/**
 * Gameクラス
 */
public abstract class Game {
    /**
     * Gameの初期化
     */
    public abstract void initGame();

    /**
     * Gameを進めます
     *
     * @param flag 各ゲームで使用するFlag
     * @return true 終了
     */
    public abstract boolean executeGame(boolean flag);

    /**
     * Game結果を返します。
     *
     * @return 結果表示用文字列
     */
    public abstract String endGame();
}

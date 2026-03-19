# Hub Server Utility Plugin  

---

## 説明 / Description  

このプラグインはHub Serverのために作られた汎用プラグインです。  
Hub Serverに必要な機能を揃えていきたいと思います。  

---
## 機能 / Feature  

1.GUI:このプラグインにある機能の設定を管理できます。  
2.初期スポーンポイント:プレイヤーがサーバーに入ったときに、任意の場所にスポーンさせる機能です。  
3.OP権限を持っていないプレイヤーによる看板の編集の有効、無効を変更する機能です。
4.ベッドによるスポーンポイントの変更を有効、無効にする機能です。

---

## コマンドの使用方法 / Command Usage  

1./hubserverutility, /hsu:
このプラグインの機能に関するGUIを表示します。  

(以下コマンドは "/hsu" と書く)  

2./hsu initialspawn  
プレイヤーが現在いる座標、向きを取得して、保存します。  
-Tips-   
/hsu isに省略が可能  

/hsu initialspawn "x" "y" "z" "yaw" "pitch"  
任意の座標と向きを保存します。  
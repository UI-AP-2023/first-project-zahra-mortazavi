package model.goods;

import model.user.buyer.BuyerModel;

public class ScoreModel {
    final private BuyerModel buyer;
    final private GoodsModel goods;
    private String score;

    public ScoreModel(BuyerModel buyer, GoodsModel goods, String score) {
        this.buyer = buyer;
        this.goods = goods;
        this.score = score;
    }

    public BuyerModel getBuyer() {
        return buyer;
    }


    public GoodsModel getGoods() {
        return goods;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }



}

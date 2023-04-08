package model.goods;

import java.util.ArrayList;

abstract public class GoodsModel {
    private  int goodsId;
    private static int mainGoodsId =0;
private String goodsName;
private double goodsPrice;
private int goodsInventory;
      private double goodsScore;
      private ArrayList<ScoreModel>scores;
      private ArrayList<CommentModel>comment;
      final private GoodsCategoryModel goodsCategoryModel;



    protected GoodsModel(String goodsName, double goodsPrice, int goodsInventory, GoodsCategoryModel goodsCategoryModel) {
        this.goodsName = goodsName;
        this.goodsCategoryModel = goodsCategoryModel;
        this.goodsPrice = goodsPrice;
        this.goodsInventory = goodsInventory;
        this.comment = new ArrayList<CommentModel>();
        this.scores=new ArrayList<ScoreModel>();
        this.mainGoodsId++;
        this.goodsId=mainGoodsId;

    }


    public ArrayList<ScoreModel> getScores() {
        return scores;
    }

    public void setScores(ArrayList<ScoreModel> scores) {
        this.scores = scores;
    }

    public static int getMainGoodsId() {
        return mainGoodsId;
    }


    public  int getGoodsId() {
        return goodsId;
    }



    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public int getGoodsInventory() {
        return goodsInventory;
    }

    public void setGoodsInventory(int goodsInventory) {
        this.goodsInventory = goodsInventory;
    }

    public double getGoodsScore() {
        return goodsScore;
    }

    public void setGoodsScore(double goodsScore) {
        this.goodsScore = goodsScore;
    }

    public ArrayList<CommentModel> getComment() {
        return comment;
    }

    public void setComment(ArrayList<CommentModel> comment) {
        this.comment = comment;
    }

    public GoodsCategoryModel getGoodsCategoryModel() {
        return goodsCategoryModel;
    }

    @Override
    public String toString() {

        return "\ngoodsID='" + goodsId + '\'' +
                "\ngoodsName='" + goodsName + '\'' +
                "\ngoodsCategoryModel=" + goodsCategoryModel +
                "\ngoodsPrice=" + goodsPrice +
                "\ngoodsNumber=" + goodsInventory +
                "\ngoodsScore=" + goodsScore
                ;
    }


}

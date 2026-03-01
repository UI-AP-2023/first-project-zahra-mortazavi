package model.goods;

import model.request.Request;
import model.user.buyer.BuyerModel;

public class CommentModel extends Request{
    public CommentModel(BuyerModel buyerModel, int goodsId, boolean purchaseStatus,String commentText){
        super();
        this.buyerModel=buyerModel;
        this.goodsId=goodsId;
        this.purchaseStatus=purchaseStatus;
        this.commentStatus= CommentStatusModel.AWAITINGACCEPTION;
       this. commentText=commentText;
    }
   final private BuyerModel buyerModel;
   final private int goodsId;
   private String commentText;
    private CommentStatusModel commentStatus;
    final private boolean purchaseStatus;


    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public CommentStatusModel getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(CommentStatusModel commentStatus) {
        this.commentStatus = commentStatus;
    }


    public boolean isPurchaseStatus() {
        return purchaseStatus;
    }


    public int getGoodsId() {
        return goodsId;
    }


    public BuyerModel getBuyerModel() {
        return buyerModel;
    }

    @Override
    public String toString() {
        return     "\nname="+buyerModel.getUserName() +
                "\ngoodsId=" + goodsId +
                "\nbought by user=" + purchaseStatus +
                "\ncommentText='" + commentText + '\'' ;
    }
}

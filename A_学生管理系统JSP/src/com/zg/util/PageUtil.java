package com.zg.util;

/**
 * @author 隔壁老王
 */
public class PageUtil{
    private int page;
    private int rows;
    private int index;
    private int countRows;
    private int countPages;
    private int prevPage;
    private int nextPage;

   public PageUtil(String page,Integer countRows){
       this.rows =5;
       this.countRows = countRows;
       initPage(page);
       initIndex();
       initCountPages();
       initPrevPage();
       initNextPage();
   }
    // 初始化页码
    private void initPage(String page) {
       if (page == null || "".equals(page)){
           this.page = 1;
       }else {
           this.page = Integer.parseInt(page);
       }
    }

    //初始化偏移量
    private void initIndex() {
       this.index = (this.page-1)*this.rows;
    }

    //初始化总页数
    private void initCountPages() {
       int mod = this.countRows % this.rows;
       if (mod == 0){
           this.countPages = this.countRows / this.rows;
       }else{
           this.countPages = this.countRows / this.rows + 1;
       }
    }

    //初始化当前页码的上一页
    private void initPrevPage() {
       if (this.page == 1){
           this.prevPage = 1;
       }else{
           this.prevPage = this.page - 1;
       }
    }

    //初始化当前页码的下一页
    private void initNextPage() {
        if(this.page == this.countPages){
            this.nextPage = this.countPages;
        }else{
            this.nextPage = this.page + 1;
        }
    }

    public int getPage() {
        return page;
    }

    public int getRows() {
        return rows;
    }

    public int getIndex() {
        return index;
    }

    public int getCountRows() {
        return countRows;
    }

    public int getCountPages() {
        return countPages;
    }

    public int getPrevPage() {
        return prevPage;
    }

    public int getNextPage() {
        return nextPage;
    }
}

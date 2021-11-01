package com.postupaylo.yandex.praktikum.cargo;

public class Cargo {
    private boolean isBig;
    private boolean fragile;

   private Cargo(boolean size, boolean fragile){
       this.isBig = size;
       this.fragile = fragile;
   }

   public boolean isBig(){
       return isBig;
   }

   public boolean isFragile(){
       return fragile;
   }

    public static class Builder{
        private boolean isBig;
        private boolean fragile;

        public Builder setBig(boolean big){
            this.isBig = big;
            return this;
        }

        public Builder setFragileProperty(boolean fragile){
            this.fragile = fragile;
            return this;
        }

        public Cargo build(){
            return new Cargo(this.isBig, this.fragile);
        }
    }
}

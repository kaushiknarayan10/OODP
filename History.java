package restapi;
import java.time.LocalDate;
import java.util.Collection;
public class History {
	int ad1, ad3, ad6, ad12, ad;	
	public History(){
		this.ad1 = 0;
		this.ad3 = 0;
		this.ad6 = 0;
		this.ad12 = 0;
		this.ad = 0;
	}
	public int getAdvertiser1(){
		SAD sad = new SAD();
		Collection<Advertiser> adlist = sad.getAdvertiser();
		for(Advertiser a : adlist){
			while(a.creationDate.getMonth().equals(LocalDate.now().getMonth())){
				this.ad1 = this.ad1+1;
			}
		}
		return this.ad1;
	}
	public int getAdvertiser3(){
		SAD sad = new SAD();
		Collection<Advertiser> adlist = sad.getAdvertiser();
		for(Advertiser a : adlist){
			while((a.creationDate.getMonth().getValue()-LocalDate.now().getMonth().getValue())
					==3){
				this.ad3 = this.ad3+1;
			}
		}
		return this.ad3;
	}
	public int getAdvertiser6(){
		SAD sad = new SAD();
		Collection<Advertiser> adlist = sad.getAdvertiser();
		for(Advertiser a : adlist){
			while((a.creationDate.getMonth().getValue()-LocalDate.now().getMonth().getValue())
					==6){
				this.ad6 = this.ad6+1;
			}
		}
		return this.ad6;
	}
	public int getAdvertiser12(){
		SAD sad = new SAD();
		Collection<Advertiser> adlist = sad.getAdvertiser();
		for(Advertiser a : adlist){
			while((a.creationDate.getMonth().getValue()-LocalDate.now().getMonth().getValue())
					==12){
				this.ad12 = this.ad12+1;
			}
		}
		return this.ad12;
	}
	public int getTotalAdvertiser(){
		SAD sad = new SAD();
		Collection<Advertiser> adlist = sad.getAdvertiser();
		this.ad = adlist.size();
		return this.ad;
	}
}

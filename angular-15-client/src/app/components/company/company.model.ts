export class Company{
  companyName: string;
  type: string;
  foundedOn: string;
  companySize: string;
  website: string;
  headquarter: string;
  address: string;
  password: string;
  about: string;

  constructor(){
    this.companyName = '';
    this.type ='Private';
    this.foundedOn = '0001';
    this.companySize = '0';
    this.website = '';
    this.headquarter = '';
    this.address = '';
    this.password = '';
    this.about ='';
  }

}

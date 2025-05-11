package cancer.earlycancer.model;

public class EarlyCancer {
	private String pid;
	private String pname;
	private Integer age;
	private Integer sex;
	private Double chr1p;
	private Double chr1q;
	private Double chr2p;
	private Double chr2q;
	private Double chr3p;
	private Double chr3q;
	private Double chr4p;
	private Double chr4q;
	private Double chr5p;
	private Double chr5q;
	private Double chr6p;
	private Double chr6q;
	private Double chr7p;
	private Double chr7q;
	private Double chr8p;
	private Double chr8q;
	private Double chr9p;
	private Double chr9q;
	private Double chr10p;
	private Double chr10q;
	private Double chr11p;
	private Double chr11q;
	private Double chr12p;
	private Double chr12q;
	private Double chr13q;
	private Double chr14q;
	private Double chr15q;
	private Double chr16p;
	private Double chr16q;
	private Double chr17p;
	private Double chr17q;
	private Double chr18p;
	private Double chr18q;
	private Double chr19p;
	private Double chr19q;
	private Double chr20p;
	private Double chr20q;
	private Double chr21q;
	private Double chr22q;
	private Double PAScore;
	private Double Fragment_Size;
	private Double FractionOfMitochondrialGenome;
	private Double GC_CorrectedFragmentRatioProfile;
	private Double Coverage;
	private String BClass;
	private String LCancerType; 
	
	
	public EarlyCancer() {
		// TODO Auto-generated constructor stub
	}
	
	
	

	public EarlyCancer(String pid, String pname, Integer age, Integer sex, Double chr1p, Double chr1q, Double chr2p,
			Double chr2q, Double chr3p, Double chr3q, Double chr4p, Double chr4q, Double chr5p, Double chr5q,
			Double chr6p, Double chr6q, Double chr7p, Double chr7q, Double chr8p, Double chr8q, Double chr9p,
			Double chr9q, Double chr10p, Double chr10q, Double chr11p, Double chr11q, Double chr12p, Double chr12q,
			Double chr13q, Double chr14q, Double chr15q, Double chr16p, Double chr16q, Double chr17p, Double chr17q,
			Double chr18p, Double chr18q, Double chr19p, Double chr19q, Double chr20p, Double chr20q, Double chr21q,
			Double chr22q, Double pAScore, Double fragment_Size, Double fractionOfMitochondrialGenome,
			Double gC_CorrectedFragmentRatioProfile, Double coverage, String class1, String cancerType) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.age = age;
		this.sex = sex;
		this.chr1p = chr1p;
		this.chr1q = chr1q;
		this.chr2p = chr2p;
		this.chr2q = chr2q;
		this.chr3p = chr3p;
		this.chr3q = chr3q;
		this.chr4p = chr4p;
		this.chr4q = chr4q;
		this.chr5p = chr5p;
		this.chr5q = chr5q;
		this.chr6p = chr6p;
		this.chr6q = chr6q;
		this.chr7p = chr7p;
		this.chr7q = chr7q;
		this.chr8p = chr8p;
		this.chr8q = chr8q;
		this.chr9p = chr9p;
		this.chr9q = chr9q;
		this.chr10p = chr10p;
		this.chr10q = chr10q;
		this.chr11p = chr11p;
		this.chr11q = chr11q;
		this.chr12p = chr12p;
		this.chr12q = chr12q;
		this.chr13q = chr13q;
		this.chr14q = chr14q;
		this.chr15q = chr15q;
		this.chr16p = chr16p;
		this.chr16q = chr16q;
		this.chr17p = chr17p;
		this.chr17q = chr17q;
		this.chr18p = chr18p;
		this.chr18q = chr18q;
		this.chr19p = chr19p;
		this.chr19q = chr19q;
		this.chr20p = chr20p;
		this.chr20q = chr20q;
		this.chr21q = chr21q;
		this.chr22q = chr22q;
		PAScore = pAScore;
		Fragment_Size = fragment_Size;
		FractionOfMitochondrialGenome = fractionOfMitochondrialGenome;
		GC_CorrectedFragmentRatioProfile = gC_CorrectedFragmentRatioProfile;
		Coverage = coverage;
		BClass = class1;
		LCancerType = cancerType;
	}
	



	public EarlyCancer(String pid, Integer age, Double chr1p, Double chr7p, Double chr8q, Double chr11q, Double chr17p,
			Double chr17q, Double chr21q, Double chr22q, Double pAScore, Double fragment_Size, String class1) {
		super();
		this.pid = pid;
		this.age = age;
		this.chr1p = chr1p;
		this.chr7p = chr7p;
		this.chr8q = chr8q;
		this.chr11q = chr11q;
		this.chr17p = chr17p;
		this.chr17q = chr17q;
		this.chr21q = chr21q;
		this.chr22q = chr22q;
		PAScore = pAScore;
		Fragment_Size = fragment_Size;
		BClass = class1;
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}




	public String getPid() {
		return pid;
	}




	public void setPid(String pid) {
		this.pid = pid;
	}




	public String getPname() {
		return pname;
	}




	public void setPname(String pname) {
		this.pname = pname;
	}




	public Integer getAge() {
		return age;
	}




	public void setAge(Integer age) {
		this.age = age;
	}




	public Integer getSex() {
		return sex;
	}




	public void setSex(Integer sex) {
		this.sex = sex;
	}




	public Double getChr1p() {
		return chr1p;
	}




	public void setChr1p(Double chr1p) {
		this.chr1p = chr1p;
	}




	public Double getChr1q() {
		return chr1q;
	}




	public void setChr1q(Double chr1q) {
		this.chr1q = chr1q;
	}




	public Double getChr2p() {
		return chr2p;
	}




	public void setChr2p(Double chr2p) {
		this.chr2p = chr2p;
	}




	public Double getChr2q() {
		return chr2q;
	}




	public void setChr2q(Double chr2q) {
		this.chr2q = chr2q;
	}




	public Double getChr3p() {
		return chr3p;
	}




	public void setChr3p(Double chr3p) {
		this.chr3p = chr3p;
	}




	public Double getChr3q() {
		return chr3q;
	}




	public void setChr3q(Double chr3q) {
		this.chr3q = chr3q;
	}




	public Double getChr4p() {
		return chr4p;
	}




	public void setChr4p(Double chr4p) {
		this.chr4p = chr4p;
	}




	public Double getChr4q() {
		return chr4q;
	}




	public void setChr4q(Double chr4q) {
		this.chr4q = chr4q;
	}




	public Double getChr5p() {
		return chr5p;
	}




	public void setChr5p(Double chr5p) {
		this.chr5p = chr5p;
	}




	public Double getChr5q() {
		return chr5q;
	}




	public void setChr5q(Double chr5q) {
		this.chr5q = chr5q;
	}




	public Double getChr6p() {
		return chr6p;
	}




	public void setChr6p(Double chr6p) {
		this.chr6p = chr6p;
	}




	public Double getChr6q() {
		return chr6q;
	}




	public void setChr6q(Double chr6q) {
		this.chr6q = chr6q;
	}




	public Double getChr7p() {
		return chr7p;
	}




	public void setChr7p(Double chr7p) {
		this.chr7p = chr7p;
	}




	public Double getChr7q() {
		return chr7q;
	}




	public void setChr7q(Double chr7q) {
		this.chr7q = chr7q;
	}




	public Double getChr8p() {
		return chr8p;
	}




	public void setChr8p(Double chr8p) {
		this.chr8p = chr8p;
	}




	public Double getChr8q() {
		return chr8q;
	}




	public void setChr8q(Double chr8q) {
		this.chr8q = chr8q;
	}




	public Double getChr9p() {
		return chr9p;
	}




	public void setChr9p(Double chr9p) {
		this.chr9p = chr9p;
	}




	public Double getChr9q() {
		return chr9q;
	}




	public void setChr9q(Double chr9q) {
		this.chr9q = chr9q;
	}




	public Double getChr10p() {
		return chr10p;
	}




	public void setChr10p(Double chr10p) {
		this.chr10p = chr10p;
	}




	public Double getChr10q() {
		return chr10q;
	}




	public void setChr10q(Double chr10q) {
		this.chr10q = chr10q;
	}




	public Double getChr11p() {
		return chr11p;
	}




	public void setChr11p(Double chr11p) {
		this.chr11p = chr11p;
	}




	public Double getChr11q() {
		return chr11q;
	}




	public void setChr11q(Double chr11q) {
		this.chr11q = chr11q;
	}




	public Double getChr12p() {
		return chr12p;
	}




	public void setChr12p(Double chr12p) {
		this.chr12p = chr12p;
	}




	public Double getChr12q() {
		return chr12q;
	}




	public void setChr12q(Double chr12q) {
		this.chr12q = chr12q;
	}




	public Double getChr13q() {
		return chr13q;
	}




	public void setChr13q(Double chr13q) {
		this.chr13q = chr13q;
	}




	public Double getChr14q() {
		return chr14q;
	}




	public void setChr14q(Double chr14q) {
		this.chr14q = chr14q;
	}




	public Double getChr15q() {
		return chr15q;
	}




	public void setChr15q(Double chr15q) {
		this.chr15q = chr15q;
	}




	public Double getChr16p() {
		return chr16p;
	}




	public void setChr16p(Double chr16p) {
		this.chr16p = chr16p;
	}




	public Double getChr16q() {
		return chr16q;
	}




	public void setChr16q(Double chr16q) {
		this.chr16q = chr16q;
	}




	public Double getChr17p() {
		return chr17p;
	}




	public void setChr17p(Double chr17p) {
		this.chr17p = chr17p;
	}




	public Double getChr17q() {
		return chr17q;
	}




	public void setChr17q(Double chr17q) {
		this.chr17q = chr17q;
	}




	public Double getChr18p() {
		return chr18p;
	}




	public void setChr18p(Double chr18p) {
		this.chr18p = chr18p;
	}




	public Double getChr18q() {
		return chr18q;
	}




	public void setChr18q(Double chr18q) {
		this.chr18q = chr18q;
	}




	public Double getChr19p() {
		return chr19p;
	}




	public void setChr19p(Double chr19p) {
		this.chr19p = chr19p;
	}




	public Double getChr19q() {
		return chr19q;
	}




	public void setChr19q(Double chr19q) {
		this.chr19q = chr19q;
	}




	public Double getChr20p() {
		return chr20p;
	}




	public void setChr20p(Double chr20p) {
		this.chr20p = chr20p;
	}




	public Double getChr20q() {
		return chr20q;
	}




	public void setChr20q(Double chr20q) {
		this.chr20q = chr20q;
	}




	public Double getChr21q() {
		return chr21q;
	}




	public void setChr21q(Double chr21q) {
		this.chr21q = chr21q;
	}




	public Double getChr22q() {
		return chr22q;
	}




	public void setChr22q(Double chr22q) {
		this.chr22q = chr22q;
	}




	public Double getPAScore() {
		return PAScore;
	}




	public void setPAScore(Double pAScore) {
		PAScore = pAScore;
	}




	public Double getFragment_Size() {
		return Fragment_Size;
	}




	public void setFragment_Size(Double fragment_Size) {
		Fragment_Size = fragment_Size;
	}




	public Double getFractionOfMitochondrialGenome() {
		return FractionOfMitochondrialGenome;
	}




	public void setFractionOfMitochondrialGenome(Double fractionOfMitochondrialGenome) {
		FractionOfMitochondrialGenome = fractionOfMitochondrialGenome;
	}




	public Double getGC_CorrectedFragmentRatioProfile() {
		return GC_CorrectedFragmentRatioProfile;
	}




	public void setGC_CorrectedFragmentRatioProfile(Double gC_CorrectedFragmentRatioProfile) {
		GC_CorrectedFragmentRatioProfile = gC_CorrectedFragmentRatioProfile;
	}




	public Double getCoverage() {
		return Coverage;
	}




	public void setCoverage(Double coverage) {
		Coverage = coverage;
	}




	public String getBClass() {
		return BClass;
	}




	public void setBClass(String bClass) {
		BClass = bClass;
	}




	public String getLCancerType() {
		return LCancerType;
	}




	public void setLCancerType(String lCancerType) {
		LCancerType = lCancerType;
	}

}

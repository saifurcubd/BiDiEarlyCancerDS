<%@page import="cancer.earlycancer.model.EOLF"%>
<%@page import="java.util.Random"%>
<%@page import="cancer.earlycancer.dao.DataInput"%>
<%@page import="weka.core.Instances"%>
<%@page import="weka.core.Instance"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>

<%
String path = application.getRealPath("/");
String dt = request.getParameter("hdnbt");
String r = request.getParameter("breset");
String res = request.getParameter("defaultInput");

String bdetection = "";
double bprob = 0;
String bprobability = "";
DataInput dataInput = null;

Instances data;
try {
	String afile = application.getRealPath("/") + "DiEarlyCancerDSFullDataInput.arff";
	//out.println(afile);
	BufferedReader bf = null;
	FileReader fr = new FileReader(afile);
	bf = new BufferedReader(fr);
	data = new Instances(bf);
	System.out.println(data.attribute(0));

} catch (Exception e) {
	out.println(e.getMessage());
	//throw new Exception();
}

String pid = "";
String name = "";
String age = "";
String sex = "";
String f1 = "", f2 = "", f3 = "", f4 = "", f5 = "", f6 = "", f7 = "", f8 = "", f9 = "", f10 = "";
String f11 = "", f12 = "", f13 = "", f14 = "", f15 = "", f16 = "", f17 = "", f18 = "", f19 = "", f20 = "";
String f21 = "", f22 = "", f23 = "", f24 = "", f25 = "", f26 = "", f27 = "", f28 = "", f29 = "", f30 = "";
String f31 = "", f32 = "", f33 = "", f34 = "", f35 = "", f36 = "", f37 = "", f38 = "", f39 = "", f40 = "";
String f41 = "", f42 = "", f43 = "", f44 = "", f45 = "", f46 = "";
String[] invalues = new String[50];

%>
<script>   
function test1(){
    alert("Please provide the require inputs]); 
}
function SexValue() {
    document.getElementById("sex").value = "<%=sex%>";
}
SexVale();
window.onload = function() {
	$('input[name="sex"]').val()='<%=sex%>';
	};
</script>
<%

if (dt == null) {
	pid = "";
	name = "";
	age = "";
	sex = "";
	f1 = "";
	f2 = "";
	f3 = "";
	f4 = "";
	f5 = "";
	f6 = "";
	f7 = "";
	f8 = "";
	f9 = "";
	f10 = "";
	f11 = "";
	f12 = "";
	f13 = "";
	f14 = "";
	f15 = "";
	f16 = "";
	f17 = "";
	f18 = "";
	f19 = "";
	f20 = "";
	f21 = "";
	f22 = "";
	f23 = "";
	f24 = "";
	f25 = "";
	f26 = "";
	f27 = "";
	f28 = "";
	f29 = "";
	f30 = "";
	f31 = "";
	f32 = "";
	f33 = "";
	f34 = "";
	f35 = "";
	f36 = "";
	f37 = "";
	f38 = "";
	f39 = "";
	f40 = "";
	f41 = "";
	f42 = "";
	f43 = "";
	f44 = "";
	f45 = "";
	f46 = "";
	bprob = 0;
	bdetection = "";
	bprobability = "";
	%>
<script>
	SexValue();
   </script>
<% 

}
if (r != null && r.equals("Reset")) {
	pid = "";
	name = "";
	age = "";
	sex = "";
	f1 = "";
	f2 = "";
	f3 = "";
	f4 = "";
	f5 = "";
	f6 = "";
	f7 = "";
	f8 = "";
	f9 = "";
	f10 = "";
	f11 = "";
	f12 = "";
	f13 = "";
	f14 = "";
	f15 = "";
	f16 = "";
	f17 = "";
	f18 = "";
	f19 = "";
	f20 = "";
	f21 = "";
	f22 = "";
	f23 = "";
	f24 = "";
	f25 = "";
	f26 = "";
	f27 = "";
	f28 = "";
	f29 = "";
	f30 = "";
	f31 = "";
	f32 = "";
	f33 = "";
	f34 = "";
	f35 = "";
	f36 = "";
	f37 = "";
	f38 = "";
	f39 = "";
	f40 = "";
	f41 = "";
	f42 = "";
	f43 = "";
	f44 = "";
	f45 = "";
	f46 = "";
	bprob = 0;
	%>
<script>
	SexValue();
   </script>
<%
}
String emsg="";

if (dt != null && dt.equals("hd")) {
	boolean infalg = false;
	double[] inputValues = new double[50];
	double[] binput = new double[11];
	for (int k = 0; k <= 45; k++)
		inputValues[k] = 0.0;

	try {
		age = request.getParameter("age");
		pid = request.getParameter("pid");
		name = request.getParameter("name");
		
		sex = request.getParameter("sex");
		//out.println("input"+sex);
		%>
<script>
		function SexValue1() {
		    document.getElementById("sex").value = "<%=sex%>";
		}
		SexVale1();
	   </script>
<%
		if (age.equals("")) {
	binput[0] = 0;
		} else {
	binput[0] = Double.parseDouble(age);

		}
		f1 = request.getParameter("f1");
		f2 = request.getParameter("f2");
		f3 = request.getParameter("f3");
		f4 = request.getParameter("f4");
		f5 = request.getParameter("f5");
		f6 = request.getParameter("f6");
		f7 = request.getParameter("f7");
		f8 = request.getParameter("f8");
		f9 = request.getParameter("f9");
		f10 = request.getParameter("f10");
		f11 = request.getParameter("f11");
		f12 = request.getParameter("f12");
		f13 = request.getParameter("f13");
		f14 = request.getParameter("f14");
		f15 = request.getParameter("f15");
		f16 = request.getParameter("f16");
		f17 = request.getParameter("f17");
		f18 = request.getParameter("f18");
		f19 = request.getParameter("f19");
		f20 = request.getParameter("f20");
		f21 = request.getParameter("f21");
		f22 = request.getParameter("f22");
		f23 = request.getParameter("f23");
		f24 = request.getParameter("f24");
		f25 = request.getParameter("f25");
		f26 = request.getParameter("f26");
		f27 = request.getParameter("f27");
		f28 = request.getParameter("f28");
		f29 = request.getParameter("f29");
		f30 = request.getParameter("f30");
		f31 = request.getParameter("f31");
		f32 = request.getParameter("f32");
		f33 = request.getParameter("f33");
		f34 = request.getParameter("f34");
		f35 = request.getParameter("f35");
		f36 = request.getParameter("f36");
		f37 = request.getParameter("f37");
		f38 = request.getParameter("f38");
		f39 = request.getParameter("f39");
		f40 = request.getParameter("f40");
		f41 = request.getParameter("f41");
		f42 = request.getParameter("f42");
		f43 = request.getParameter("f43");
		f44 = request.getParameter("f44");

		for (int j = 0; j < 45; j++) {
	String f = request.getParameter("f" + (j + 1));
	//out.println("f"+f);
	if (f != null && !f.equals("")) {
		inputValues[j] = Double.parseDouble(f);
		//out.println("f="+j);
		//out.println("v:"+inputValues[j]);

	} else {
%>
<script>   
		    test();
		   </script>
<%
			break;

	}
}

//f40
binput[1] = inputValues[39];//f40
binput[2] = Double.parseDouble(f1);
//binput[2] = inputValues[0];//chr1p (f1)
binput[3] = inputValues[12];//chr7p (f13)
binput[4] = inputValues[15];//chr8q (f16)
binput[5] = inputValues[21];//chr11q (f22)
binput[6] = inputValues[29];//chr17p (f30)
binput[7] = inputValues[30];//chr17q (f31)
binput[8] = inputValues[37];//chr21q (f38)
binput[9] = inputValues[38];//chr22q (f39)
binput[10] = inputValues[40];//Fragmentation size (f41)

EOLF eolf = new EOLF();
eolf.binaryPrediction(binput);
if (eolf.blabel == 0) {
bdetection = "Cancer";
} else
bdetection = "Normal";
bprob = eolf.bpred[0];
//dataInput.defaultValues();
bprobability = String.format("%.02f", bprob * 100);

} catch (NullPointerException e) {
out.println("Null:"+e.getMessage());
%>
<script>   
	    test();
	   </script>
<%
} catch (Exception e) {	
	emsg="Please provide the require inputs";
%>
<script> 
        function test(){
            alert("Please provide the require inputs"); 
        }
	    test();
	   </script>
<%

}

}
if (res != null && res.equals("Input a default random WGS cfDNA Framentation profile data from system")) {
dataInput = new DataInput();
name = "Default patient data";
try {
dataInput.defaultValues();
for (int i = 3; i < dataInput.fin.length; i++) {
	invalues[i - 3] = String.valueOf(dataInput.fin[i]);
	//out.print(invalues[i]);
}
pid = dataInput.pid;
age = dataInput.age;
sex = String.valueOf((int) dataInput.fin[2]);
//out.println("Deafualt input sex"+sex);
%>
<script>
		function SexValue3() {
		    document.getElementById("sex").value = "<%=sex%>";
		}
		SexVale3();
	   </script>
<% 
int y = 3;
f1 = String.valueOf(dataInput.fin[3]);
f2 = String.valueOf(dataInput.fin[2 + 2]);
f3 = String.valueOf(dataInput.fin[2 + 3]);
f4 = String.valueOf(dataInput.fin[2 + 4]);
f5 = String.valueOf(dataInput.fin[2 + 5]);
f6 = String.valueOf(dataInput.fin[2 + 6]);
f7 = String.valueOf(dataInput.fin[2 + 7]);
f8 = String.valueOf(dataInput.fin[2 + 8]);
f9 = String.valueOf(dataInput.fin[2 + 9]);
f10 = String.valueOf(dataInput.fin[2 + 10]);
f11 = String.valueOf(dataInput.fin[2 + 11]);
f12 = String.valueOf(dataInput.fin[2 + 12]);
f13 = String.valueOf(dataInput.fin[2 + 13]);
f14 = String.valueOf(dataInput.fin[2 + 14]);
f15 = String.valueOf(dataInput.fin[2 + 15]);
f16 = String.valueOf(dataInput.fin[2 + 16]);
f17 = String.valueOf(dataInput.fin[2 + 17]);
f18 = String.valueOf(dataInput.fin[2 + 18]);
f19 = String.valueOf(dataInput.fin[2 + 19]);
f20 = String.valueOf(dataInput.fin[2 + 20]);
f21 = String.valueOf(dataInput.fin[2 + 21]);
f22 = String.valueOf(dataInput.fin[2 + 22]);
f23 = String.valueOf(dataInput.fin[2 + 23]);
f24 = String.valueOf(dataInput.fin[2 + 24]);
f25 = String.valueOf(dataInput.fin[2 + 25]);
f26 = String.valueOf(dataInput.fin[2 + 26]);
f27 = String.valueOf(dataInput.fin[2 + 27]);
f28 = String.valueOf(dataInput.fin[2 + 28]);
f29 = String.valueOf(dataInput.fin[2 + 29]);
f30 = String.valueOf(dataInput.fin[2 + 30]);
f31 = String.valueOf(dataInput.fin[2 + 31]);
f32 = String.valueOf(dataInput.fin[2 + 32]);
f33 = String.valueOf(dataInput.fin[2 + 33]);
f34 = String.valueOf(dataInput.fin[2 + 34]);
f35 = String.valueOf(dataInput.fin[2 + 35]);
f36 = String.valueOf(dataInput.fin[2 + 36]);
f37 = String.valueOf(dataInput.fin[2 + 37]);
f38 = String.valueOf(dataInput.fin[2 + 38]);
f39 = String.valueOf(dataInput.fin[2 + 39]);
f40 = String.valueOf(dataInput.fin[2 + 40]);
f41 = String.valueOf(dataInput.fin[2 + 41]);
f42 = String.valueOf(dataInput.fin[2 + 42]);
f43 = String.valueOf(dataInput.fin[2 + 43]);
f44 = String.valueOf(dataInput.fin[2 + 44]);
String a = "1";
bprob = 0;

} catch (Exception e) {
out.println(e.getMessage());

}
}
%>
<script>   
window.onload = function() {
	$('input[name="bip"]').val()='<%=bprob%>';
	$('input[name="sex"]').val()='<%=sex%>';
	};

</script>
<%
//binary prediction

//out.println(bprob);
//out.println(bdetection);

//localize prediction
String ldetection = "";
double lprob = 0;
//out.println("out Deafualt input sex"+sex);
%>
<html>
<head>
<title>DiEarlyCancerDS: Patient Data Input and Cancer Detection</title>


<STYLE type="text/css">
.contains {
	background-image: url('detection_bg.png');
	background-repeat: no-repeat;
	background-size: 1000px 720px;
	height: 720px;
	position: relative;
	width: 1000px;
}

}
#home_button {
	
}
/*
#DetectButton {
	padding: 2px;
	border-radius: 2px;
	border: 2px solid green;
	text-align: center;
	font-style: oblique;
	top: 2%;
	align-items: center;
	left: 300px;
	width: 200px;
	position: relative;
}

submit {
	font-size: 20px;
	padding: 2px;
	border-radius: 2px;
	border: 2px solid black;
	text-align: center;
	font-style: oblique;
	position: relative;
}
*/
.info {
	font-size: 20px;
	border: 2px solid black;
	text-align: center;
	width: 98%;
	top: 110px;
	align-items: center;
	left: 1%;
	position: relative;
}

.inp {
	width: 54%;
	background-color: Transparent;
	top: 118px;
	left: 1%;
	position: relative;
	float: left;
}

.reset {
	font-size: 20px;
	padding: 2px;
	border-radius: 5px;
	border: 2px solid black;
	text-align: center;
	width: 100px;
	align-items: center;
	position: fixed;
	margin: 0;
}

.result {
	border: 3px solid black;
	width: 42%;
	background-color: Transparent;
	top: 118px;
	right: 1%;
	position: relative;
	align-self: right;
	float: right;
	height: 480px;
}
/*
.lc {
	border: 3px solid gray;
	width: 40%;
	background-color: Transparent;
	left: 58%;
	position: fixed;
	top: 170px;
}
*/
#bid {
	border-width: 8px;
	border-style: solid;
	border-top-color: red;
	border-right-color: green;
	border-bottom-color: purple;
	border-left-color: blue;
}

h3 {
	margin: 2px;
	padding: 2px;
}

h4 {
	margin: 2px;
	padding: 2px;
}

td {
	
}

/
*
input {
	border: 1px solid black;
	align-items: left;
	position: relative;
}

#data {
	border-collapse: collapse;
	width: 100%;
	position: relative;
	margin: 0;
	column-gap: 5px;
}
</STYLE>

</head>
<body>
	<%
	String yes = request.getParameter("localizePrediction");
	if (yes != null && yes.equals("Yes")) {
		bprob = Double.valueOf(request.getParameter("bprob"));
		bdetection = request.getParameter("bdetection");
		//out.println("ProB submit:=" + bprob);
		//out.println("ProB submit:=" + bdetection);
	}
	
	
	double[] linput = new double[45];
	if (yes != null && yes.equals("Yes")) {
		
		
		//out.println("Binary Pro (yes): "+bprob);
		//Localize cancer detection
		bprobability=request.getParameter("bprobability");
		//out.println("Binary Pro (yes) string: "+bprob);
		f1 = request.getParameter("f1");
		f2 = request.getParameter("f2");
		f3 = request.getParameter("f3");
		f4 = request.getParameter("f4");
		f5 = request.getParameter("f5");
		f6 = request.getParameter("f6");
		f7 = request.getParameter("f7");
		f8 = request.getParameter("f8");
		f9 = request.getParameter("f9");
		f10 = request.getParameter("f10");
		f11 = request.getParameter("f11");
		f12 = request.getParameter("f12");
		f13 = request.getParameter("f13");
		f14 = request.getParameter("f14");
		f15 = request.getParameter("f15");
		f16 = request.getParameter("f16");
		f17 = request.getParameter("f17");
		f18 = request.getParameter("f18");
		f19 = request.getParameter("f19");
		f20 = request.getParameter("f20");
		f21 = request.getParameter("f21");
		f22 = request.getParameter("f22");
		f23 = request.getParameter("f23");
		f24 = request.getParameter("f24");
		f25 = request.getParameter("f25");
		f26 = request.getParameter("f26");
		f27 = request.getParameter("f27");
		f28 = request.getParameter("f28");
		f29 = request.getParameter("f29");
		f30 = request.getParameter("f30");
		f31 = request.getParameter("f31");
		f32 = request.getParameter("f32");
		f33 = request.getParameter("f33");
		f34 = request.getParameter("f34");
		f35 = request.getParameter("f35");
		f36 = request.getParameter("f36");
		f37 = request.getParameter("f37");
		f38 = request.getParameter("f38");
		f39 = request.getParameter("f39");
		f40 = request.getParameter("f40");
		f41 = request.getParameter("f41");
		f42 = request.getParameter("f42");
		f43 = request.getParameter("f43");
		f44 = request.getParameter("f44");
		age = request.getParameter("age");
		pid = request.getParameter("pid");
		name = request.getParameter("name");
		%>
	<script>
		SexValue();
	   </script>
	<%
		sex = request.getParameter("sex");
		if (age.equals("")) {
			linput[0] = 0;
		} else {
			linput[0] = Double.parseDouble(age);

		}
		//out.println("Yes input sex"+sex);

		double[] inputValues = new double[50];
		for (int k = 1; k < 45; k++)
			inputValues[k] = 0.0;

		for (int j = 1; j < 45; j++) {
			String f = request.getParameter("f"+j);
			if (f != null) {
		inputValues[j] = Double.parseDouble(f);
		 //out.println("f="+j);
		//out.println("v:"+inputValues[j]);
			}

		}
		//sex
		//sex = "0";
		linput[1] = Double.parseDouble(sex);
		for (int m = 1, n = 3; m < 40; m++, n++) {
			linput[n] = inputValues[m];
		}
		linput[2] = inputValues[40];
		linput[42] = inputValues[41];
		linput[43] = inputValues[43];

		//again set value to show
		f1 = String.valueOf(inputValues[1]);
		f2 = String.valueOf(inputValues[2]);
		f3 = String.valueOf(inputValues[3]);
		f4 = String.valueOf(inputValues[4]);
		f5 = String.valueOf(inputValues[5]);
		f6 = String.valueOf(inputValues[6]);
		f7 = String.valueOf(inputValues[7]);
		f8 = String.valueOf(inputValues[8]);
		f9 = String.valueOf(inputValues[9]);
		f10 = String.valueOf(inputValues[10]);
		f11 = String.valueOf(inputValues[11]);
		f12 = String.valueOf(inputValues[12]);
		f13 = String.valueOf(inputValues[13]);
		f14 = String.valueOf(inputValues[14]);
		f15 = String.valueOf(inputValues[15]);
		f16 = String.valueOf(inputValues[16]);
		f17 = String.valueOf(inputValues[17]);
		f18 = String.valueOf(inputValues[18]);
		f19 = String.valueOf(inputValues[19]);
		f20 = String.valueOf(inputValues[20]);
		f21 = String.valueOf(inputValues[21]);
		f22 = String.valueOf(inputValues[22]);
		f23 = String.valueOf(inputValues[23]);
		f24 = String.valueOf(inputValues[24]);
		f25 = String.valueOf(inputValues[25]);
		f26 = String.valueOf(inputValues[26]);
		f27 = String.valueOf(inputValues[27]);
		f28 = String.valueOf(inputValues[28]);
		f29 = String.valueOf(inputValues[29]);
		f30 = String.valueOf(inputValues[30]);
		f31 = String.valueOf(inputValues[31]);
		f32 = String.valueOf(inputValues[32]);
		f33 = String.valueOf(inputValues[33]);
		f34 = String.valueOf(inputValues[34]);
		f35 = String.valueOf(inputValues[35]);
		f36 = String.valueOf(inputValues[36]);
		f37 = String.valueOf(inputValues[37]);
		f38 = String.valueOf(inputValues[38]);
		f39 = String.valueOf(inputValues[39]);
		f40 = String.valueOf(inputValues[40]);
		f41 = String.valueOf(inputValues[41]);
		f42 = String.valueOf(inputValues[42]);
		f43 = String.valueOf(inputValues[43]);
		f44 = String.valueOf(inputValues[44]);
		
		for (int j = 1; j < 45; j++) {
			String f = request.getParameter("f"+j);
		  // out.println("f="+j);
		  //  out.println("v:"+inputValues[j]);
			}
		
		bprobability = String.format("%.02f", bprob * 100);
	}

	
	
	
	//	out.println("notProB:="+bprob);
	%>


	<div class="contains"
		style="align-self: center; border: 5px solid black; margin: auto;">
		<div>
			<form action="<%=request.getContextPath()%>/index.jsp" method="post">
				<input type="submit" id="home_button" alt="Home"
					value="     Home    "
					style="position: relative; font-size: 20px; padding: 2px; border-radius: 2px; border: 2px solid black; text-align: center; font-style: oblique; align-items: center; left: 8%; top: 105px; width: 100px;" />
			</form>
		</div>
		<form name="detectionForm"
			action="<%=request.getContextPath()%>/detection.jsp" method="post">
			<input type="hidden" value="<%=bprob%>" name="bprob" /> <input
				type="hidden" value="<%=bdetection%>" name="bdetection" />

			<div class="info">
				<table id="data">
					<tr>
						<td style="width: 100px;">Patient's ID:<input type="text"
							value="<%=pid%>" name="pid" style="width: 80px;" /></td>
						<td style="width: 100px;">Name:<input type="text"
							value="<%=name%>" name="name" style="width: 200px;" /></td>
						<td width="100px">Age: <input type="text" value="<%=age%>"
							name="age" style="width: 80px;" /></td>
						<td>Gender:</td>

						<td><select name="sex" id="sex">
								<option value="1">Male</option>
								<option value="0">Female</option>
						</select></td>


						<td style="width: 200px;">Blood Sample ID:<input type="text"
							value="" name="bid" style="width: 200px;" /></td>
						<td style="width: 200px;">WGS No:<input type="text" value=""
							name="wgs" style="width: 200px;" /></td>
					</tr>
				</table>
			</div>
			<div class="inp">
				<table cellpadding="0" cellspacing="0"
					style="border-spacing: 5px; border-collapse: separate; border: 1px solid black;">
					<tr>
						<td colspan="4">cfDNA Fragmentation Size:&nbsp;</td>
						<td><input type="text" value="<%=f41%>" name="f41"
							style="width: 50px;" /></td>
						<td colspan="2" rowspan="2"><input type="hidden" name="hdnbt" />
							<input type="hidden" name="bip" value="<%=bprob%>" /> <input
							type="image" name="detection" value="hd" id="DetectButton"
							src="detect.png" border="3" style="padding: 2px; width: 150px"
							alt="Cancer Detect"
							onclick="{document.detectionForm.hdnbt.value=this.value;document.detectionForm.submit();}" /></td>
						<script>	
							
							</script>

						</script>
					</tr>
					<tr>
						<td colspan="4">GC corrected total and Short fragment:
						<td><input type="text" value="<%=f43%>" name="f43"
							style="width: 50px;" /></td>
					</tr>
					<tr>
						<td colspan="4">Plasma Aneuploidy (PA) Score:</td>
						<td><input type="text" value="<%=f40%>" align="right"
							name="f40" style="width: 50px;" /></td>
					</tr>
					<tr>
						<td colspan="4">Mitochrondrial Read rate from cfDNA:</td>
						<td><input type="text" value="<%=f42%>" align="right"
							name="f42" style="width: 50px;" /></td>
						<td colspan="3"><h5 style="margin: 0"><%=emsg%></h5></td>
					</tr>
					<tr>
						<td colspan="4">Total coverage:</td>
						<td><input type="text" value="<%=f44%>" align="right"
							name="f44" style="width: 50px;" /></td>
					</tr>
					<tr>
						<td colspan="6" style="margin: 0;"><h4>Chromosomal arm
								CNV (Z-Scores)</h4></td>
						<!--  	<td><input type="text" value="<%=bprob%>" name="bprob"style="width: 0px; height: 0px" /></td>-->
					</tr>
					<tr>
						<td>chr1p:</td>
						<td><input type="text" value="<%=f1%>" name="f1"
							style="width: 50px;" /></td>
						<td>chr1q:</td>
						<td><input type="text" value="<%=f2%>" name="f2"
							style="width: 50px;" /></td>
						<td>chr2p:</td>
						<td><input type="text" value="<%=f3%>" name="f3"
							style="width: 50px;" /></td>
						<td>chr2q:</td>
						<td><input type="text" value="<%=f4%>" name="f4"
							style="width: 50px;" /></td>
					</tr>

					<tr>
						<td>chr3p:</td>
						<td><input type="text" value="<%=f5%>" name="f5"
							style="width: 50px;" /></td>
						<td>chr3q:</td>
						<td><input type="text" value="<%=f6%>" name="f6"
							style="width: 50px;" /></td>
						<td>chr4p:</td>
						<td><input type="text" value="<%=f7%>" name="f7"
							style="width: 50px;" /></td>
						<td>chr4q:</td>
						<td><input type="text" value="<%=f8%>" name="f8"
							style="width: 50px;" /></td>
					</tr>

					<tr>
						<td>chr5p:</td>
						<td><input type="text" value="<%=f9%>" name="f9"
							style="width: 50px;" /></td>
						<td>chr5q:</td>
						<td><input type="text" value="<%=f10%>" name="f10"
							style="width: 50px;" /></td>
						<td>chr6p:</td>
						<td><input type="text" value="<%=f11%>" name="f11"
							style="width: 50px;" /></td>
						<td>chr6q:</td>
						<td><input type="text" value="<%=f12%>" name="f12"
							style="width: 50px;" /></td>
					</tr>

					<tr>
						<td>chr7p:</td>
						<td><input type="text" value="<%=f13%>" name="f13"
							style="width: 50px;" /></td>
						<td>chr7q:</td>
						<td><input type="text" value="<%=f14%>" name="f14"
							style="width: 50px;" /></td>
						<td>chr8p:</td>
						<td><input type="text" value="<%=f15%>" name="f15"
							style="width: 50px;" /></td>
						<td>chr8q:</td>
						<td><input type="text" value="<%=f16%>" name="f16"
							style="width: 50px;" /></td>
					</tr>

					<tr>
						<td>chr9p:</td>
						<td><input type="text" value="<%=f17%>" name="f17"
							style="width: 50px;" /></td>
						<td>chr9q:</td>
						<td><input type="text" value="<%=f18%>" name="f18"
							style="width: 50px;" /></td>
						<td>chr10p:</td>
						<td><input type="text" value="<%=f19%>" name="f19"
							style="width: 50px;" /></td>
						<td>chr10q:</td>
						<td><input type="text" value="<%=f20%>" name="f20"
							style="width: 50px;" /></td>
					</tr>

					<tr>
						<td>chr11p:</td>
						<td><input type="text" value="<%=f21%>" name="f21"
							style="width: 50px;" /></td>
						<td>chr11q:</td>
						<td><input type="text" value="<%=f22%>" name="f22"
							style="width: 50px;" /></td>
						<td>chr12p:</td>
						<td><input type="text" value="<%=f23%>" name="f23"
							style="width: 50px;" /></td>
						<td>chr12q:</td>
						<td><input type="text" value="<%=f24%>" name="f24"
							style="width: 50px;" /></td>
					</tr>

					<tr>
						<td>chr13q:</td>
						<td><input type="text" value="<%=f25%>" name="f25"
							style="width: 50px;" /></td>
						<td>chr14q:</td>
						<td><input type="text" value="<%=f26%>" name="f26"
							style="width: 50px;" /></td>
						<td>chr15q:</td>
						<td><input type="text" value="<%=f27%>" name="f27"
							style="width: 50px;" /></td>
						<td>chr16p:</td>
						<td><input type="text" value="<%=f28%>" name="f28"
							style="width: 50px;" /></td>
					</tr>

					<tr>
						<td>chr16q:</td>
						<td><input type="text" value="<%=f29%>" name="f29"
							style="width: 50px;" /></td>
						<td>chr17p:</td>
						<td><input type="text" value="<%=f30%>" name="f30"
							style="width: 50px;" /></td>
						<td>chr17q:</td>
						<td><input type="text" value="<%=f31%>" name="f31"
							style="width: 50px;" /></td>
						<td>chr18p:</td>
						<td><input type="text" value="<%=f32%>" name="f32"
							style="width: 50px;" /></td>
					</tr>

					<tr>
						<td>chr18q:</td>
						<td><input type="text" value="<%=f33%>" name="f33"
							style="width: 50px;" /></td>
						<td>chr19p:</td>
						<td><input type="text" value="<%=f34%>" name="f34"
							style="width: 50px;" /></td>
						<td>chr19q:</td>
						<td><input type="text" value="<%=f35%>" name="f35"
							style="width: 50px;" /></td>
						<td>chr20p:</td>
						<td><input type="text" value="<%=f36%>" name="f36"
							style="width: 50px;" /></td>
					</tr>
					<tr>
						<td>chr20q:</td>
						<td><input type="text" value="<%=f37%>" name="f37"
							style="width: 50px;" /></td>
						<td>chr21q:</td>
						<td><input type="text" value="<%=f38%>" name="f38"
							style="width: 50px;" /></td>
						<td>chr22q:</td>
						<td><input type="text" value="<%=f39%>" name="f39"
							style="width: 50px;" /></td>
					</tr>

				</table>
				<br /> <input type="submit" name="breset" value="Reset"> <input
					type="submit" name="defaultInput" id="default" width="250px"
					height="45px" alt="Default"
					value="Input a default random WGS cfDNA Framentation profile data from system" />

				<br />
			</div>
			<div class="result" style="text-align: center;">

				<%
				//bprob =Double.parseDouble(request.getParameter("bprob"));
				//out.println("Binary Pro: "+bprob);
				if (bprob == 0) {
				%>
				<h2 align="center" id="bid" style="margin: 0;">
					Cancer detection Result will be here...<br />
				</h2>
				<h4>Cancer Detection DiEarlyCancerDS System Flowchart:</h4>
				<img alt="" width="80%" height="400px" src="dc.png"
					style="background: transparent;">

				<%
				} else {
				%>
				<h2 align="center" id="bid">
					Cancer detection Result<br />
				</h2>
				<TABLE style="align: center; text-align: center;">
					<%
					if (bdetection.equals("Cancer")) {
					%>
					<tr>
						<h1 style="align: center; color: red;">Cancer Patient</h1>
					</tr>
					<tr>
						<h4>
							<input type="hidden" name="bpr" value="<%=bprobability%>" />
							Cancer Detection probability:
							<%=bprobability%>%
						</h4>
					</tr>
					<tr>
						<td colspan="2"><h4 align="center">Do you want to
								localize the cancer organ?</h4></td>
					</tr>
					<tr>
						<%
						//  if (!yes.equals("Yes")) {
						%>
						<td colspan="2" align="center"><input type="submit"
							name="localizePrediction" width="250px" height="45px" alt="Yes"
							value="Yes" /></td>
						<%//} %>
						<!-- "{document.detectionForm.hdnbt.value=this.value;document.detectionForm.submit();}" 
							 onclick="{document.detectionForm.bprob.value=bprob;document.detectionForm.submit();}"-->

					</tr>
					<%
					String x = request.getParameter("localizePrediction");
					//String g = request.getParameter("sex");
					if (x != null && x.equals("Yes")) {
						/*
						
						out.println("Binary Pro (yes): "+bprob);
						//Localize cancer detection
						bprobability=request.getParameter("bprobability");
						out.println("Binary Pro (yes) string: "+bprob);
						f1 = request.getParameter("f1");
						f2 = request.getParameter("f2");
						f3 = request.getParameter("f3");
						f4 = request.getParameter("f4");
						f5 = request.getParameter("f5");
						f6 = request.getParameter("f6");
						f7 = request.getParameter("f7");
						f8 = request.getParameter("f8");
						f9 = request.getParameter("f9");
						f10 = request.getParameter("f10");
						f11 = request.getParameter("f11");
						f12 = request.getParameter("f12");
						f13 = request.getParameter("f13");
						f14 = request.getParameter("f14");
						f15 = request.getParameter("f15");
						f16 = request.getParameter("f16");
						f17 = request.getParameter("f17");
						f18 = request.getParameter("f18");
						f19 = request.getParameter("f19");
						f20 = request.getParameter("f20");
						f21 = request.getParameter("f21");
						f22 = request.getParameter("f22");
						f23 = request.getParameter("f23");
						f24 = request.getParameter("f24");
						f25 = request.getParameter("f25");
						f26 = request.getParameter("f26");
						f27 = request.getParameter("f27");
						f28 = request.getParameter("f28");
						f29 = request.getParameter("f29");
						f30 = request.getParameter("f30");
						f31 = request.getParameter("f31");
						f32 = request.getParameter("f32");
						f33 = request.getParameter("f33");
						f34 = request.getParameter("f34");
						f35 = request.getParameter("f35");
						f36 = request.getParameter("f36");
						f37 = request.getParameter("f37");
						f38 = request.getParameter("f38");
						f39 = request.getParameter("f39");
						f40 = request.getParameter("f40");
						f41 = request.getParameter("f41");
						f42 = request.getParameter("f42");
						f43 = request.getParameter("f43");
						f44 = request.getParameter("f44");
						age = request.getParameter("age");
						pid = request.getParameter("pid");
						name = request.getParameter("name");
						sex = request.getParameter("sex");
						if (age.equals("")) {
							linput[0] = 0;
						} else {
							linput[0] = Double.parseDouble(age);
						
						}
						
						double[] inputValues = new double[50];
						for (int k = 1; k < 45; k++)
							inputValues[k] = 0.0;
						
						for (int j = 1; j < 45; j++) {
							String f = request.getParameter("f" + 1);
							if (f != null) {
						inputValues[j] = Double.parseDouble(f);
						//out.println("f="+j);
						//out.println("v:"+inputValues[j]);
							}
						
						}
						//sex
						sex = "0";
						linput[1] = Double.parseDouble(sex);
						for (int m = 1, n = 3; m < 40; m++, n++) {
							linput[n] = inputValues[m];
						}
						linput[2] = inputValues[40];
						linput[42] = inputValues[41];
						linput[43] = inputValues[43];
						
						//again set value to show
						f1 = String.valueOf(inputValues[1]);
						f2 = String.valueOf(inputValues[2]);
						f3 = String.valueOf(inputValues[3]);
						f4 = String.valueOf(inputValues[4]);
						f5 = String.valueOf(inputValues[5]);
						f6 = String.valueOf(inputValues[6]);
						f7 = String.valueOf(inputValues[7]);
						f8 = String.valueOf(inputValues[8]);
						f9 = String.valueOf(inputValues[9]);
						f10 = String.valueOf(inputValues[10]);
						f11 = String.valueOf(inputValues[11]);
						f12 = String.valueOf(inputValues[12]);
						f13 = String.valueOf(inputValues[13]);
						f14 = String.valueOf(inputValues[14]);
						f15 = String.valueOf(inputValues[15]);
						f16 = String.valueOf(inputValues[16]);
						f17 = String.valueOf(inputValues[17]);
						f18 = String.valueOf(inputValues[18]);
						f19 = String.valueOf(inputValues[19]);
						f20 = String.valueOf(inputValues[20]);
						f21 = String.valueOf(inputValues[21]);
						f22 = String.valueOf(inputValues[22]);
						f23 = String.valueOf(inputValues[23]);
						f24 = String.valueOf(inputValues[24]);
						f25 = String.valueOf(inputValues[25]);
						f26 = String.valueOf(inputValues[26]);
						f27 = String.valueOf(inputValues[27]);
						f28 = String.valueOf(inputValues[28]);
						f29 = String.valueOf(inputValues[29]);
						f30 = String.valueOf(inputValues[30]);
						f31 = String.valueOf(inputValues[31]);
						f32 = String.valueOf(inputValues[32]);
						f33 = String.valueOf(inputValues[33]);
						f34 = String.valueOf(inputValues[34]);
						f35 = String.valueOf(inputValues[35]);
						f36 = String.valueOf(inputValues[36]);
						f37 = String.valueOf(inputValues[37]);
						f38 = String.valueOf(inputValues[38]);
						f39 = String.valueOf(inputValues[39]);
						f40 = String.valueOf(inputValues[40]);
						f41 = String.valueOf(inputValues[41]);
						f42 = String.valueOf(inputValues[42]);
						f43 = String.valueOf(inputValues[43]);
						f44 = String.valueOf(inputValues[44]);
						*/
						EOLF eolf = new EOLF();
						eolf.LocalizePrediction(linput);
						//'Patient Type' {'Colorectal Cancer','Breast Cancer','Lung Cancer','Ovarian Cancer','Pancreatic Cancer',
						//	 'Bile Duct Cancer','Gastric cancer'}
					//	out.println("Input Sex check" + linput[1]);
						//out.println("Sex" + sex);
					//	linput[1] = 1;

						if (eolf.llabel == 0) {
							ldetection = "Colorectal Cancer";
						} else if (eolf.llabel == 1 && linput[1] == 0) {
							ldetection = "Breast Cancer";
						} else if (eolf.llabel == 2) {
							ldetection = "Lung Cancer";
						} else if (eolf.llabel == 3 && linput[1] == 0) {
							ldetection = "Ovarian Cancer";
						} else if (eolf.llabel == 4) {
							ldetection = "Pancreatic Cancer";
						} else if (eolf.llabel == 5) {
							ldetection = "Bile Duct Cancer";
						} else if (eolf.llabel == 6) {
							ldetection = "Gastric cancer";
						} else {
							double[] lmalePro = { eolf.lpred[0], eolf.lpred[2], eolf.lpred[4], eolf.lpred[5], eolf.lpred[6] };
							String[] MaleCancer = { "Colorectal Cancer", "Lung Cancer", "Pancreatic Cancer", "Bile Duct Cancer",
							"Gastric cancer" };
							double max = 0;
							int index = 0;

							for (int i = 0; i < lmalePro.length; i++) {
						         if (max < lmalePro[i]) {
						           	max = lmalePro[i];
						          	index = i;
						          }
						    	}
							ldetection = MaleCancer[index];
						}

						// bdetection="Normal";
						// bprob=eolf.bpred[0]; 

						if (linput[1] == 0) { //All cancer Female
							String.format("%.02f", bprob * 100);
					%>

					<tr>
						<td colspan="2" align="center" style="color: maroon;">
							<h2><%=ldetection%></h2>
						</td>
					</tr>
					<!--  'Patient Type' {'Colorectal Cancer','Breast Cancer','Lung Cancer','Ovarian Cancer','Pancreatic Cancer','Bile Duct Cancer','Gastric cancer'}-->
					<tr>
						<td><h4>
								Colorectal Cancer (<%=String.format("%.02f", eolf.lpred[0] * 100)%>%)
							</h4></td>
						<td><h4>
								Lung Cancer (<%=String.format("%.02f", eolf.lpred[2] * 100)%>%)
							</h4></td>
					</tr>

					<tr>
						<td><h4>
								Pancreatic Cancer (<%=String.format("%.02f", eolf.lpred[4] * 100)%>%)
							</h4></td>
						<td><h4>
								Bile Duct Cancer (<%=String.format("%.02f", eolf.lpred[5] * 100)%>%)
							</h4></td>
					</tr>
					<tr>
						<td><h4>
								Gastric cancer(<%=String.format("%.02f", eolf.lpred[6] * 100)%>%)
							</h4></td>
					</tr>
					<tr>
						<td><h4>
								Ovarian Cancer (<%=String.format("%.02f", eolf.lpred[3] * 100)%>%)
							</h4></td>
						<td><h4>
								Breast Cancer (<%=String.format("%.02f", eolf.lpred[1] * 100)%>%)
							</h4></td>
					</tr>

					<%
					} else { //male camcer
					%>

					<tr>
						<td colspan="2" align="center" style="color: maroon;">
							<h2><%=ldetection%></h2>
						</td>
					</tr>
					<!--  'Patient Type' {'Colorectal Cancer','Breast Cancer','Lung Cancer','Ovarian Cancer','Pancreatic Cancer','Bile Duct 							Cancer','Gastric cancer'}-->

					<tr>
						<td><h4>
								Colorectal Cancer (<%=String.format("%.02f", eolf.lpred[0] * 100)%>%)
							</h4></td>
						<td><h4>
								Lung Cancer (<%=String.format("%.02f", eolf.lpred[2] * 100)%>%)
							</h4></td>
					</tr>

					<tr>
						<td><h4>
								Pancreatic Cancer (<%=String.format("%.02f", eolf.lpred[4] * 100)%>%)
							</h4></td>
						<td><h4>
								Bile Duct Cancer (<%=String.format("%.02f", eolf.lpred[5] * 100)%>%)
							</h4></td>
					</tr>
					<tr>
						<td><h4>
								Gastric cancer(<%=String.format("%.02f", eolf.lpred[6] * 100)%>%)
							</h4></td>
					</tr>

					<%
					}
					} //localize Cancer

					} //End Cancer

					else { //Normal
					%>
					<tr>
						<h1 style="align: center; color: green;">Normal Condition</h1>
					</tr>
					<tr>
						<h4>
							Cancer Detection probability:
							<%=bprobability%>%
							<%
							double npro=Double.parseDouble(bprobability);
							%>
							
						</h4>
					</tr>
					<%
					if (npro > 40) {
					%>
					<tr>
						<h2 style="color: purple;">Please take cancer prevention and consults with a oncologist !!</h3>
					</tr>
					<%
					} else {
					%>
					<tr>
						<h2 style="color: green;">Congratulations!!! You are Healthy person</h3>
					</tr>
					<%
					}
					%>
				</TABLE>
				<%
				}
				}
				%>

			</div>


		</form>
	</div>
</body>
</html>

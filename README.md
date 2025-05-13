# BiDiEarlyCancerDS Web Application Implementation for ClinicalEarlyCancerDF
  Manuscript Title: ClinicalEarlyCancerDF: a clinical early cancer detection framework using genome-wide cell-free DNA profiles and biomarkers from non-invasive liquid biopsy


**Graphical Abstract**

</p>

<img width="1018" alt="System_performace" src="https://github.com/user-attachments/assets/aa48731f-d5c8-429f-8ba1-e36c3f31f67f" />


![alt text](https://github.com/user-attachments/assets/7acd9078-edf7-4b25-9123-8a6bb8e25cf5)

<p align="center">
ClinicalEarlyCancerDF Study Overview
</p>


# BiDiEarlyCancerDS Web Application Implementation
To facilitate clinical interpretation and real-time use of the ClinicalEarlyCancerDF framework, we developed BiDiEarlyCancerDS, a dynamic, platform-independent web application. The system allows users (e.g., clinicians or researchers) to input cfDNA fragmentation profiles, mutational signatures, and biomarker values from non-invasive liquid biopsy (NLB) data. The application provides immediate predictions for both binary early cancer detection (ECD) and localized cancer type classification, leveraging the optimized ensemble learning models described in this study.

# Key Features:
• Interactive prediction interface for binary and localized ECD
• Visualization of individual patient results via ROC curves, prediction scores, and heatmaps
• Upload functionality for DELFI-format data files
• Real-time summary of classification confidence and cancer type probabilities

The backend is implemented in Python using Flask, and the frontend is built with ReactJS and D3.js for interactive data visualizations. Model integration is facilitated through pre-trained models stored as serialized Python objects (.pkl), and the system uses RESTful API calls to manage data input/output.

# Availability:
The current version of BiDiEarlyCancerDS is available for research purposes upon request from the corresponding author. We plan to release a cloud-hosted version with secure authentication and logging support in a future update, along with user documentation and a Docker-based deployment script.

# Future Development:
We aim to integrate BiDiEarlyCancerDS with hospital EHR systems and initiate pilot usability studies with clinical partners. Enhancements will also include broader cancer type support and real-time decision support integration for early intervention planning.

</p>

![alt text](https://github.com/saifurcubd/BiDiEarlyCancerDS/blob/main/EarlyCancerDF-figures.png)

# BiDiEarlyCancerDS User Guide
**1. Overview**

BiDiEarlyCancerDS is a web-based clinical support tool designed for early cancer detection using non-invasive liquid biopsy (NLB) data. The system implements the ClinicalEarlyCancerDF framework to provide binary and localized cancer prediction outcomes. It offers intuitive visualization, robust model predictions, and is intended to support clinicians in early diagnostic assessment.


**2. User Interface Features**
Figure S9: Input and Detection Interface

    Data Upload Panel: Users can upload DELFI- or CancerSEEK-format datasets (CSV) including cfDNA fragmentation features, mutation signatures, or protein biomarkers.

    Patient ID Selector: Allows selection of an individual patient record from the dataset.

    Model Type Toggle: Users can switch between Binary Detection and Localized Detection modes.

    Run Detection Button: Initiates real-time prediction using the trained ensemble models.

Figure S10: Output Dashboard

    Binary ECD Output: Displays predicted cancer status (Cancer / Healthy), along with model confidence score (probability).

    Localized ECD Output: If “Cancer” is predicted, a bar graph ranks possible cancer types by probability.

    ROC Curve Visualization: Plots the receiver operating characteristic curve for model confidence.

    Heatmap (Figure S6): Visual representation of mutational signature contributions for the selected sample.

**3. Use Case Examples**
Figure S11: Binary ECD Scenarios

    (a) Cancer Detection: The model flags a high-confidence cancer prediction.

    (b) Normal Condition: The model predicts healthy status with strong confidence.

    (c) Prevention Monitoring: Used for routine monitoring; can compare time-series entries.

Figure S12: Localized ECD by Gender

    (a) Female Patient Example: Shows cancer localization probabilities, such as high likelihood of breast or ovarian cancer.

    (b) Male Patient Example: Distinguishes male-dominant cancer types like prostate or lung cancer.

**4. Technical Requirements**

    Browser: Chrome, Firefox, or Edge (latest versions)

    Backend: Python Flask API (with pre-trained model objects)

    Frontend: ReactJS interface, D3.js for plots

    Deployment: Docker script provided for local or server deployment

**5. Access and Availability**

    The application is currently available upon request for academic and research use. To request access or deployment support, please contact the corresponding author.

    A cloud-hosted version with extended data privacy, login support, and documentation is under development.




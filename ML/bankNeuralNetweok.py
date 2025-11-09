# Practical - Customer Churn Prediction
# Simple Logistic Regression Model

import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import LabelEncoder
from sklearn.linear_model import LogisticRegression
from sklearn.metrics import accuracy_score, confusion_matrix, classification_report
import seaborn as sns
import matplotlib.pyplot as plt

# Step 1: Load dataset
data = pd.read_csv("Churn_Modelling.csv")

# Step 2: Select required columns (Features & Target)
X = data[['CreditScore', 'Geography', 'Gender', 'Age', 'Balance', 'EstimatedSalary']]
y = data['Exited']   # Target

# Step 3: Encode categorical values
le = LabelEncoder()
X['Geography'] = le.fit_transform(X['Geography'])
X['Gender'] = le.fit_transform(X['Gender'])

# Step 4: Split Data (Training & Testing)
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.3, random_state=42)

# Step 5: Train Model
model = LogisticRegression()
model.fit(X_train, y_train)

# Step 6: Prediction
y_pred = model.predict(X_test)

# Step 7: Performance Evaluation
print("Accuracy:", accuracy_score(y_test, y_pred))
print("\nConfusion Matrix:\n", confusion_matrix(y_test, y_pred))
print("\nClassification Report:\n", classification_report(y_test, y_pred))



sns.countplot(x=data['Exited'])
plt.title("Customer Churn (0 = Stayed, 1 = Left)")
plt.xlabel("Exited")
plt.ylabel("Number of Customers")
plt.show()
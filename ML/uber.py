# Import libraries
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import warnings
warnings.filterwarnings("ignore")

# Import data
data = pd.read_csv("uber.csv")

# Create a copy
df = data.copy()

# Preview data
print(df.head())
print(df.info())

# Convert pickup_datetime to datetime type
df['pickup_datetime'] = pd.to_datetime(df['pickup_datetime'])

# Check missing values
print("Missing values:\n", df.isnull().sum())

# Drop rows with missing values
df.dropna(inplace=True)

# Statistics of data
print(df.describe())

# Visualize fare_amount outliers
plt.boxplot(df['fare_amount'])
plt.title("Fare Amount Distribution")
plt.show()

# Remove outliers (keep 1st to 99th percentile)
q_low = df['fare_amount'].quantile(0.01)
q_hi = df['fare_amount'].quantile(0.99)
df = df[(df['fare_amount'] >= q_low) & (df['fare_amount'] <= q_hi)]

# Prepare features (X) and target (y)
X = df.drop(['fare_amount', 'Unnamed: 0'], axis=1, errors='ignore')
y = df['fare_amount']

# Convert pickup_datetime to numeric timestamp
X['pickup_datetime'] = X['pickup_datetime'].view(np.int64) / 1e9

# Keep only numeric columns
X = X.select_dtypes(include=[np.number])

# Check final feature types
print("Feature types:\n", X.dtypes)

# Split data into train and test sets
from sklearn.model_selection import train_test_split
X_train, X_test, y_train, y_test = train_test_split(
    X, y, test_size=0.2, random_state=1
)

# ---------------- Linear Regression ----------------
from sklearn.linear_model import LinearRegression
from sklearn.metrics import mean_squared_error, r2_score

lr_model = LinearRegression()
lr_model.fit(X_train, y_train)

# Predictions
lr_pred = lr_model.predict(X_test)

# Evaluation
lr_rmse = np.sqrt(mean_squared_error(y_test, lr_pred))
lr_r2 = r2_score(y_test, lr_pred)
print("Linear Regression → RMSE:", lr_rmse, "R²:", lr_r2)

# ---------------- Random Forest Regressor ----------------
from sklearn.ensemble import RandomForestRegressor

rf_model = RandomForestRegressor(n_estimators=10, random_state=101)
rf_model.fit(X_train, y_train)

# Predictions
rf_pred = rf_model.predict(X_test)

# Evaluation
rf_rmse = np.sqrt(mean_squared_error(y_test, rf_pred))
rf_r2 = r2_score(y_test, rf_pred)
print("Random Forest → RMSE:", rf_rmse, "R²:", rf_r2)



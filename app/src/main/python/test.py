import pandas as pd
from sklearn.linear_model import LogisticRegression
from sklearn.model_selection import train_test_split
from io import StringIO
from os.path import dirname, join
def mark(filename):
    # filename = join(r,"creditcard.csv")
    data = pd.read_csv(filename)
    # Split data into training and testing sets
    X_train, X_test, y_train, y_test = train_test_split(data.drop('Class', axis=1), data['Class'], random_state=0)
    # Train a logistic regression model
    lr = LogisticRegression(max_iter=10000).fit(X_train, y_train)
    # Evaluate the model on the testing set
    score = lr.score(X_test, y_test)
    if score < 0.5:
        return 'The model is worse than guessing! and fraud'
    else:
        return  f'legitimate({score*100:.2f}%)'
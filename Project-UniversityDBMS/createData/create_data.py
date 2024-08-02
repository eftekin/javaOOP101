import random

import pandas as pd
from faker import Faker

fake = Faker()

# Academicians table
academicians = []
for i in range(1, 21):
    academicians.append(
        [i, fake.first_name(), fake.last_name(), f"C{random.randint(100, 199)}"]
    )

academicians_df = pd.DataFrame(
    academicians, columns=["AcademicianID", "Name", "Surname", "CourseCode"]
)
academicians_df.to_csv("academicians.csv", index=False)

# Student table
students = []
for i in range(1, 20):
    students.append(
        [i, fake.first_name(), fake.last_name(), f"C{random.randint(100, 199)}"]
    )

students_df = pd.DataFrame(
    students, columns=["StudentID", "Name", "Surname", "CourseCode"]
)
students_df.to_csv("students.csv", index=False)

# Courses table
courses = []
for i in range(100, 200):
    courses.append([f"C{i}", fake.catch_phrase()])

courses_df = pd.DataFrame(courses, columns=["CourseCode", "CourseName"])
courses_df.to_csv("courses.csv", index=False)

print("CSV files were created successfully.")

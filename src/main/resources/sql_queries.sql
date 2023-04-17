-- Employees (names) who have a bigger salary than their manager
SELECT a.emp_name FROM Employee a JOIN Employee b
ON a.mngr_id = b.emp_id
WHERE a.salary > b.salary;

-- Employees who have the biggest salary in their Department
SELECT a.emp_name, a.dept_id
FROM Employee a JOIN
(SELECT a.dept_id, MAX(salary) as max_salary
FROM Employee a JOIN Department b ON a.dept_id = b.dept_id
GROUP BY a.dept_id) b
ON a.salary = b.max_salary AND a.dept_id = b.dept_id;

--SQL query to list Departments that have less than 3 people in it?
select d.dept_name, COUNT(e.emp_name)  from Employee1 e right outer join 
Department d on e.dept_id = d.dept_id 
group by d.dept_id
having COUNT(e.emp_name) < 3 

--SQL query to show all Departments along with the number of people there?
select d.dept_name, COUNT(e.emp_name)  from Employee1 e right outer join 
Department d on e.dept_id = d.dept_id 
group by d.dept_id

-- All Department along with the number of people there
SELECT b.dept_name, COUNT(a.dept_id) as 'Number of Employee' FROM Employee a FULL OUTER JOIN Department b ON a.dept_id=b.dept_id GROUP BY b.dept_name;

-- Employees that don't have a manager in the same department
SELECT a.emp_name FROM Employee a JOIN Employee b
ON a.mngr_id = b.emp_id
WHERE a.dept_id != b.dept_id;

-- All Department along with the total salary there
SELECT b.dept_name, SUM(a.salary) as 'Total Salary'
FROM Employee a FULL OUTER JOIN Department b ON a.dept_id = b.dept_id
GROUP BY b.dept_name;

-- difference between row_number(), rank(), and dense_rank() 
-- will only visible when there were duplicates.
-- row_number gives consecutive ranking even with duplicate 
-- rank and dense_rank give the same ranking but rank has a jump 
-- while dense_rank doesn't have jump 
select e.*, row_number() over (order by salary desc) row_number,
 rank() over (order by salary desc) rank, dense_rank() over (order by salary desc) as dense_rank from #Employee e

Read more: https://javarevisited.blogspot.com/2016/07/difference-between-rownumber-rank-and-denserank-sql-server.html#ixzz7z6IcwU7j

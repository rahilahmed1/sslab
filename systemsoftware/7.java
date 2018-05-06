import java.util.Scanner;
class ROUNDROBIN {
public static void main(String args[]) {
Scanner s = new Scanner(System.in);
int wtime[],btime[],rtime[],num,quantum,total;
wtime = new int[10];
btime = new int[10];
rtime = new int[10];
System.out.print("Enter number of processes(MAX 10): ");
num = s.nextInt();
System.out.print("Enter burst time");
for(int i=0;i<num;i++) { System.out.print("\nP["+(i+1)+"]: ");
btime[i] = s.nextInt(); rtime[i] = btime[i]; wtime[i]=0; }
System.out.print("\n\nEnter quantum: "); quantum = s.nextInt();
int rp = num; int i=0; int time=0; System.out.print("0");
wtime[0]=0; while(rp!=0) { if(rtime[i]>quantum)
{
rtime[i]=rtime[i]-quantum;
System.out.print(" | P["+(i+1)+"] | ");
time+=quantum;
System.out.print(time);}
else if(rtime[i]<=quantum && rtime[i]>0)
{time+=rtime[i];
rtime[i]=rtime[i]-rtime[i];
System.out.print(" | P["+(i+1)+"] | ");
rp--;
System.out.print(time);
}
i++;
if(i==num)
{
i=0;
}
}
}
}

class SHORTESTJOBFIRST{
public static void main(String args[]){
int
burst_time[],process[],waiting_time[],tat[],i,j,n,total=0,pos,temp
;
float wait_avg,TAT_avg;
Scanner s = new Scanner(System.in);
System.out.print("Enter number of process: ");
n = s.nextInt();
process = new int[n];
burst_time = new int[n];
waiting_time = new int[n];
tat = new int[n];System.out.println("\nEnter Burst time:");
for(i=0;i<n;i++)
{
System.out.print("\nProcess["+(i+1)+"]: ");
burst_time[i] = s.nextInt();;
process[i]=i+1; //Process Number
}
//Sorting
for(i=0;i<n;i++)
{
pos=i;
for(j=i+1;j<n;j++)
{
if(burst_time[j]<burst_time[pos])
pos=j;
}
temp=burst_time[i];
burst_time[i]=burst_time[pos];
burst_time[pos]=temp;
temp=process[i];
process[i]=process[pos];
process[pos]=temp;
}
//First process has 0 waiting time
waiting_time[0]=0;
//calculate waiting time
for(i=1;i<n;i++)
{
waiting_time[i]=0;
for(j=0;j<i;j++)
waiting_time[i]+=burst_time[j];
total+=waiting_time[i];
}
//Calculating Average waiting time
wait_avg=(float)total/n;
total=0;
System.out.println("\nProcess\t Burst Time \tWaiting Time\tTurnaround Time");
for(i=0;i<n;i++)
{
tat[i]=burst_time[i]+waiting_time[i]; //Calculating Turnaround
total+=tat[i];
System.out.println("\n p"+process[i]+"\t\t "+burst_time[i]+"\t\t "+waiting_time[i]+"\t\t "+tat[i]);
}
//Calculation of Average Turnaround Time
TAT_avg=(float)total/n;
System.out.println("\n\nAverage Waiting Time: "+wait_avg);
System.out.println("\nAverage Turnaround Time: "+TAT_avg);
}
}

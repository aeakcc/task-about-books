class Main{
    public static void main(String[] args) {
        Status status = Status.ARCHIVED;
        BookMover bookMover = new FromArchivedStatusMover();
        Status resultStatus = bookMover.bookMover(status, Status.AVAILABLE);
        System.out.println((resultStatus != null && resultStatus == Status.AVAILABLE)
                ? "Available"
                : "Impossible");
    }
}
enum Status {
    AVAILABLE("Available"),
    BORROWED("Borrowed"),
    OVERDUED("Overdued"),
    ARCHIVED("Archived");
    String status;
    Status(String status){
        this.status = status;
    }
    public String getStatus(){
        return status;
    }
}
class BookMover {
    public Status bookMover(Status currentStatus, Status requiredStatus){
        currentStatus = requiredStatus;
        return currentStatus;
    }
}
class FromArchivedStatusMover extends BookMover{
    @Override
    public Status bookMover(Status currentStatus, Status requiredStatus){
        if(requiredStatus.getStatus().equals("Available")) {
            return requiredStatus;
        }
        else return null;
    }
}
class FromAvailableStatusMover extends BookMover{
    @Override
    public Status bookMover(Status currentStatus, Status requiredStatus){
        if(requiredStatus.getStatus().equals("Archived") || requiredStatus.getStatus().equals("Borrowed")) {
            currentStatus = requiredStatus;
            return currentStatus;
        }
        else return null;
    }
}
class FromBorrowedStatusMover extends BookMover{
    @Override
    public Status bookMover(Status currentStatus, Status requiredStatus){
        if(requiredStatus.getStatus().equals("Archived") || requiredStatus.getStatus().equals("Overdued")) {
            currentStatus = requiredStatus;
            return currentStatus;
        }
        else return null;
    }
}
class FromOverDuedStatusMover extends BookMover{
    @Override
    public Status bookMover(Status currentStatus, Status requiredStatus){
        if(requiredStatus.getStatus().equals("Archived") || requiredStatus.getStatus().equals("Available")) {
            currentStatus = requiredStatus;
            return currentStatus;
        }
        else return null;
    }
}

# ATMMachine
I) Project này sẽ thực hiện lại chức năng của một máy ATM, bao gồm những chức năng như: 
1) Đăng nhập tài khoản 
2) Kiểm tra số dư ( View Balance )
3) Rút tiền (Withdraw Amount)
4) Chuyển tiền vào tài khoản (Deposit Amount)
5) Thống kê lại các biến động số dư trong tài khoản (View Mini Statement)
6) Đăng xuất khỏi tài khoản (Exit)

II) Project sẽ sử dụng các lớp sau:
1) Lớp ATM: Lớp này sẽ chịu trách nhiệm thực hiện chức năng khởi tạo, lưu trữ dữ liệu và đặt lại dữ liệu cho biến:
  - Cấu trúc của lớp ATM:
    + Main noun: ATM
    + Auxiliary nouns: balance, depositBalance, withdrawBalance
    + Verbs: getBalance(), setBalance(), getDeposit(), setDeposit(), getWithdraw(), setWithDraw()
  - Mô hình UML:
    + Fields:
      * balance, depositBalance, withdrawBalance : int
    + Methods:
      * getBalance(), getDeposit(), getWithdraw() : int
      * setBalance(), setDeposit(), setWithdraw() : void
3) Lớp Main: Lớp này sẽ chịu trách nhiệm thực hiện việc khởi động, xác thực thông tin đăng nhập của người dùng; tạo ra menu tùy chọn các hoạt động trong tài khoản, đảm bảo cho ứng dụng được hoạt động liên tục cho đến khi người dùng đăng xuất; đăng xuất người dùng khỏi tài khoản
  - Cấu trúc của lớp Main:
    + Main noun: Main
    + Auxiliary nouns: op, object, authenticated
    + Verbs: authenticated, viewBalance(), withdrawAmount(), depositAmount(), ViewMiniStatement(), break
  - Cấu trúc UML:
    + Fields:
      * ATMNumber, ATMPin, AttemptNumber, AttemptPin, option, withdraw, deposit: int
      * authenticated: boolean
      * op: OperationInterface
    + Method:
      * main(args: String[]): void 
4) Lớp OperationImplement: Lớp này sẽ chịu trách nhiệm thực hiện việc quản lý và thao tác dữ liệu người dùng dựa trên các phương thức được tạo ra ở lớp OperationImplement
  - Cấu trúc của lớp OpertaionImplement:
    + Main noun: OperationImplement
    + Auxiliary nouns: atm, ministatement
    + Verbs: viewBalance(), withdrawAmount(), depositAmount(), ViewMiniStatement()
  - Mô hình UML:
    + Fields:
      * atm: ATM
      * ministatement: HashMap<>()
    + Methods:
      * viewBalance(), withdrawAmount(), depositAmount(), ViewMiniStatement(): void 
5) Lớp OperationInterface: Lớp này sẽ chịu trách nhiệm thực hiện việc xác định các hành động có thể thực hiện
  - Cấu trúc của lớp OperationInterface:
    + Main noun: OperationInterface
    + Auxiliary nouns:
      * Do đây là phần sử dụng phương thức interface nên không sử dụng Auxiliary noun
    + Verbs: viewBalance(), withdrawAmount(), depositAmount(), ViewMiniStatement()
  - Mô hình UML:
    + Fields:
    + Methods:
      * viewBalance(), withdrawAmount(), depositAmount(), ViewMiniStatement(): void

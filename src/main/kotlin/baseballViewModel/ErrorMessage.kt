package baseballViewModel

enum class ErrorMessage(val message:String){
    INPUT_SIZE_ERROR("[Error]숫자는 3개 모두 입력하셔야합니다."),
    MISS_RANGE("[Error]숫자는 1부터 9까지로 구성되어있습니다."),
    DUPLICATE_NUMBER("[Error]중복된 숫자가 존재합니다."),
    ONLY_NUMBERS("[Error]숫자만 입력 가능합니다."),
    ONE_OR_TWO("[Error]1 또는 2를 입력하세요."),


}
class Solution
{
    static int StrStr(string haystack, string needle)
    {
        if (String.IsNullOrEmpty(needle)) return 0;

        for (int i = 0; i < haystack.Length - needle.Length + 1; i++)
        {
            if (haystack.Substring(i, needle.Length) == needle) return i;
        }
        return -1;
    }

    static void Main(string[] args)
    {
        Console.WriteLine(StrStr("hello", "o"));
    }
}